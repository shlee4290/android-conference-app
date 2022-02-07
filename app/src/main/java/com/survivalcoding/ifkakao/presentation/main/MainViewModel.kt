package com.survivalcoding.ifkakao.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.usecase.GetHighlightSessionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getHighlightSessionsUseCase: GetHighlightSessionsUseCase) :
    ViewModel() {

    private val _highlightSessions = MutableStateFlow<List<Session>>(listOf())
    val highlightSessions = _highlightSessions.asStateFlow()

    init {
        viewModelScope.launch {
            _highlightSessions.value = getHighlightSessionsUseCase()
            println(_highlightSessions.value)
        }
    }
}