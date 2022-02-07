package com.survivalcoding.ifkakao.presentation.categorySession

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.domain.entity.Categories
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.usecase.GetSelectedSessionsUseCase
import com.survivalcoding.ifkakao.presentation.common.CommonBinder
import com.survivalcoding.ifkakao.presentation.common.FooterBinder
import com.survivalcoding.ifkakao.presentation.common.SessionListItemBinder
import com.survivalcoding.ifkakao.presentation.common.SessionTitleBinder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategorySessionViewModel @Inject constructor(private val getSelectedSessionsUseCase: GetSelectedSessionsUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow(UiState(listOf()))
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun refreshTitleAndSessions(title: String, categories: Categories) {
        viewModelScope.launch {
            val binderList = mutableListOf<CommonBinder>()
            binderList.add(SessionTitleBinder(title))
            binderList.addAll(convertSessionListToBinderList(getSelectedSessionsUseCase(categories = categories)))
            binderList.add(FooterBinder())
            _uiState.value = _uiState.value.copy(binderList = binderList)
        }
    }

    private fun convertSessionListToBinderList(sessionList: List<Session>): List<SessionListItemBinder> {
        return sessionList.map { SessionListItemBinder(it, ::onClickSessionListItem) }
    }

    private fun onClickSessionListItem(session: Session) {
        sendEvent(Event.NavigateToSessionDetail(session))
    }

    private fun sendEvent(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

    data class UiState(
        val binderList: List<CommonBinder>
    )

    sealed class Event {
        class NavigateToSessionDetail(val session: Session) : Event()
    }
}