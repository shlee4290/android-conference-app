package com.survivalcoding.ifkakao.presentation.sessiondetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.usecase.GetSelectedSessionsUseCase
import com.survivalcoding.ifkakao.presentation.common.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SessionDetailViewModel @Inject constructor(
    private val getSelectedSessionsUseCase: GetSelectedSessionsUseCase
) : ViewModel() {

    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _uiState = MutableStateFlow(UiState(listOf()))
    val uiState = _uiState.asStateFlow()

    private var session: Session? = null

    private var associatedSessionLastPage: Int = 1

    fun setSession(session: Session) {
        this.session = session
        refreshBinderList(session)
    }

    private fun refreshBinderList(session: Session) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(binderList = buildSessionDetailBinderList(session))
        }
    }

    private suspend fun buildSessionDetailBinderList(session: Session): List<CommonBinder> {
        val fieldCategory = if (session.category.field.isNotEmpty()) {
            session.category.field.first()
        } else {
            ""
        }

        val relatedSessions = viewModelScope.async {
            getSelectedSessionsUseCase(category = Category(field = listOf(fieldCategory)))
        }

        return SessionDetailBinderListBuilder()
            .addVideo(
                session, { url -> sendEvent(Event.NavigateToWebView(url)) },
                {} // TODO
            ).addCategory(session)
            .addTitle(session)
            .addContent(session)
            .addTags(session)
            .addSpeakers(session)
            .addButton("목록보기") { sendEvent(Event.NavigateToSessionList) }
            .addAssociatedSessions(
                relatedSessions.await(),
                associatedSessionLastPage * ASSOCIATED_SESSION_PAGE_SIZE,
                session,
                { clickedSession ->
                    sendEvent(
                        Event.NavigateToSessionDetail(
                            clickedSession
                        )
                    )
                },
                { loadNextAssociatedSessionPage() }
            ).addFooter()
            .build()
    }

    private fun loadNextAssociatedSessionPage() {
        ++associatedSessionLastPage
        viewModelScope.launch {
            refreshBinderList(
                this@SessionDetailViewModel.session ?: return@launch
            )
        }
    }

    private fun sendEvent(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

    sealed class Event {
        class NavigateToWebView(val url: String) : Event()
        class NavigateToSessionDetail(val session: Session) : Event()
        object NavigateToSessionList : Event()
        class NavigateToCategorySessionList(val category: Category, val title: String) : Event()
    }

    data class UiState(
        val binderList: List<CommonBinder>
    )

    companion object {
        private const val ASSOCIATED_SESSION_PAGE_SIZE = 5
    }
}

class SessionDetailBinderListBuilder {

    private val tmpBinderList = mutableListOf<CommonBinder>()

    fun build(): List<CommonBinder> = tmpBinderList

    fun addVideo(
        session: Session,
        onPlayButtonClick: (String) -> Unit,
        onShareButtonClick: () -> Unit
    ): SessionDetailBinderListBuilder {
        if (session.video.isNotEmpty()) {
            tmpBinderList.add(
                SessionVideoBinder(
                    session.video.first(),
                    session.thumbnailUrl,
                    session.title,
                    onPlayButtonClick,
                    onShareButtonClick
                )
            )
        }
        return this
    }

    fun addCategory(session: Session): SessionDetailBinderListBuilder {
        tmpBinderList.add(CategoryListBinder(session.category))
        return this
    }

    fun addTitle(session: Session): SessionDetailBinderListBuilder {
        tmpBinderList.add(SessionTitleBinder(session.title))
        return this
    }

    fun addContent(session: Session): SessionDetailBinderListBuilder {
        tmpBinderList.add(SessionContentBinder(session.content))
        return this
    }

    fun addTags(session: Session): SessionDetailBinderListBuilder {
        tmpBinderList.add(SessionTagsBinder(session.contentTag))
        return this
    }

    fun addSpeakers(session: Session): SessionDetailBinderListBuilder {
        tmpBinderList.addAll(
            session.contentsSpeakers.map {
                SpeakerBinder(it)
            }
        )
        return this
    }

    fun addAssociatedSessions(
        associatedSessionList: List<Session>,
        associatedSessionLastIndex: Int,
        currentSession: Session,
        onSessionClick: (Session) -> Unit,
        onMoreButtonClick: () -> Unit
    ): SessionDetailBinderListBuilder {
        if (associatedSessionList.none { it.idx != currentSession.idx }) return this

        tmpBinderList.add(AssociatedSessionTitleBinder())
        tmpBinderList.addAll(
            associatedSessionList.take(associatedSessionLastIndex)
                .filter { it.idx != currentSession.idx }
                .map {
                    SessionListItemBinder(
                        it, onSessionClick
                    )
                }
        )
        if (associatedSessionLastIndex < associatedSessionList.size - 1) {
            addButton("연관세션 더보기") { onMoreButtonClick() }
        }
        return this
    }

    fun addButton(text: String, onClick: () -> Unit): SessionDetailBinderListBuilder {
        tmpBinderList.add(SessionButtonBinder(text, onClick))
        return this
    }

    fun addFooter(): SessionDetailBinderListBuilder {
        tmpBinderList.add(FooterBinder())
        return this
    }
}