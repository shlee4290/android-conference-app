package com.survivalcoding.ifkakao.presentation.sessiondetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakao.sdk.link.LinkClient
import com.survivalcoding.ifkakao.domain.entity.Categories
import com.survivalcoding.ifkakao.domain.entity.CategoriesBuilder
import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.usecase.AddFavoriteSessionUseCase
import com.survivalcoding.ifkakao.domain.usecase.GetSelectedSessionsUseCase
import com.survivalcoding.ifkakao.domain.usecase.RemoveFavoriteSessionUseCase
import com.survivalcoding.ifkakao.presentation.common.CommonBinder
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
    private val getSelectedSessionsUseCase: GetSelectedSessionsUseCase,
    private val addFavoriteSessionUseCase: AddFavoriteSessionUseCase,
    private val removeFavoriteSessionUseCase: RemoveFavoriteSessionUseCase
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
        val fieldCategory = if (session.categories.field.isNotEmpty()) {
            session.categories.field.first()
        } else {
            Category.Field("")
        }

        val relatedSessions = viewModelScope.async {
            getSelectedSessionsUseCase(categories = Categories(field = listOf(fieldCategory)))
        }

        return SessionDetailBinderListBuilder()
            .setSession(session)
            .addVideo(
                { url -> sendEvent(Event.NavigateToWebView(url)) },
                { sendEvent(Event.ShareSession(session.idx)) }
            ).addCategory { navigateToCategorySessionList(it) }
            .addTitle()
            .addContent()
            .addTags()
            .addSpeakers()
            .addLinks(
                { sendEvent(Event.ShareSessionWithTalk(session.idx)) },
                {},
                {},
                { sendEvent(Event.CopySessionLink(session.idx)) },
                ::onFavoriteChanged
            )
            .addButton("목록보기") { sendEvent(Event.NavigateToSessionList) }
            .addAssociatedSessions(
                relatedSessions.await(),
                associatedSessionLastPage * ASSOCIATED_SESSION_PAGE_SIZE,
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

    private fun onFavoriteChanged(isFavorite: Boolean) {
        viewModelScope.launch {
            if (isFavorite) {
                addFavoriteSessionUseCase(session?.idx ?: return@launch)
            } else {
                removeFavoriteSessionUseCase(session?.idx ?: return@launch)
            }
        }
    }

    private fun loadNextAssociatedSessionPage() {
        ++associatedSessionLastPage
        viewModelScope.launch {
            refreshBinderList(
                this@SessionDetailViewModel.session ?: return@launch
            )
        }
    }

    private fun navigateToCategorySessionList(category: Category) {
        sendEvent(
            Event.NavigateToCategorySessionList(
                CategoriesBuilder().add(category).build(),
                category.text
            )
        )
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
        class NavigateToCategorySessionList(val categories: Categories, val title: String) : Event()
        class ShareSessionWithTalk(val sessionIdx: Int) : Event()
        class ShareSession(val sessionIdx: Int) : Event()
        class CopySessionLink(val sessionIdx: Int) : Event()
    }

    data class UiState(
        val binderList: List<CommonBinder>
    )

    companion object {
        private const val ASSOCIATED_SESSION_PAGE_SIZE = 5
    }
}