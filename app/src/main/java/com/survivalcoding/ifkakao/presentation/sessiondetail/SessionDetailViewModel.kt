package com.survivalcoding.ifkakao.presentation.sessiondetail

import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.presentation.common.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SessionDetailViewModel @Inject constructor(): ViewModel() {

    private val _uiState = MutableStateFlow(SessionDetailUiState(listOf()))
    val uiState = _uiState.asStateFlow()

    var session: Session? = null
        set(value) {
            field = value

            if (value == null) return
            val binderList = mutableListOf<CommonBinder>()

            binderList.add(
                SessionVideoBinder(
                    value.video.first(),
                    value.thumbnailUrl,
                    value.title,
                    {},// TODO
                    {}// TODO
                )
            )
            binderList.add(SessionTitleBinder(value.title))
            binderList.add(SessionContentBinder(value.content))
            binderList.add(SessionTagsBinder(value.contentTag))
            binderList.addAll(
                value.contentsSpeakers.map {
                    SpeakerBinder(it)
                }
            )
            binderList.add(FooterBinder())

            _uiState.value = _uiState.value.copy(binderList = binderList)
        }
}

data class SessionDetailUiState(
    val binderList: List<CommonBinder>
)