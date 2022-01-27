package com.survivalcoding.ifkakao.presentation.main

import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.domain.usecase.GetHighlightSessionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getHighlightSessionsUseCase: GetHighlightSessionsUseCase) :
    ViewModel() {
}