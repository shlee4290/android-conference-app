package com.survivalcoding.ifkakao.presentation.session

import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.domain.usecase.GetSelectedSessionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(private val getSelectedSessionsUseCase: GetSelectedSessionsUseCase) :
    ViewModel() {
}