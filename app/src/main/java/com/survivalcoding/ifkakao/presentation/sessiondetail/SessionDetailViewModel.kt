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