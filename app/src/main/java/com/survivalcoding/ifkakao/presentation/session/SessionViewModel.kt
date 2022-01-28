package com.survivalcoding.ifkakao.presentation.session

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.usecase.GetSelectedSessionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(private val getSelectedSessionsUseCase: GetSelectedSessionsUseCase) :
    ViewModel() {

    private val _sessionUiState = MutableStateFlow(SessionUiState(listOf(), listOf(), listOf()))
    val sessionUiState = _sessionUiState.asStateFlow()

    init {
        viewModelScope.launch {
            _sessionUiState.value = SessionUiState(
                getSelectedSessionsUseCase(1),
                getSelectedSessionsUseCase(2),
                getSelectedSessionsUseCase(3),
            )
        }
    }
}

data class SessionUiState(
    val day1Sessions: List<Session>,
    val day2Sessions: List<Session>,
    val day3Sessions: List<Session>,
)