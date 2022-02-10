package com.survivalcoding.ifkakao.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.usecase.GetHighlightSessionsUseCase
import com.survivalcoding.ifkakao.presentation.common.CommonBinder
import com.survivalcoding.ifkakao.presentation.common.FooterBinder
import com.survivalcoding.ifkakao.presentation.common.LoadingIndicatorBinder
import com.survivalcoding.ifkakao.presentation.common.SessionListItemBinder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getHighlightSessionsUseCase: GetHighlightSessionsUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow(UiState(listOf(LoadingIndicatorBinder())))
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                binderList = getHighlightSessionsUseCase().map {
                    SessionListItemBinder(it, ::navigateToSessionDetail)
                }.plus(FooterBinder())
            )
        }
    }

    private fun navigateToSessionDetail(session: Session) {
        sendEvent(Event.NavigateToSessionDetail(session.idx))
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
        class NavigateToSessionDetail(val id: Int) : Event()
    }
}