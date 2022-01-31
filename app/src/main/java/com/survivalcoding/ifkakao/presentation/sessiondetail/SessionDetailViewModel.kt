package com.survivalcoding.ifkakao.presentation.sessiondetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.usecase.GetAllCategoriesUseCase
import com.survivalcoding.ifkakao.domain.usecase.GetSelectedSessionsUseCase
import com.survivalcoding.ifkakao.presentation.common.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SessionDetailViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getSelectedSessionsUseCase: GetSelectedSessionsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SessionDetailUiState(listOf()))
    val uiState = _uiState.asStateFlow()

    var session: Session? = null
        set(value) {
            field = value

            if (value == null) return

            viewModelScope.launch {
                val relatedSessions = async {
                    val fieldCategory = Category(field = listOf(value.category.field.first()))
                    getSelectedSessionsUseCase(category = fieldCategory)
                }

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
                binderList.addAll(
                    relatedSessions.await().filter { it.idx != value.idx }
                        .map { SessionListItemBinder(it, {}) } // TODO
                )
                binderList.add(FooterBinder())

                _uiState.value = _uiState.value.copy(binderList = binderList)
            }
        }
}

data class SessionDetailUiState(
    val binderList: List<CommonBinder>
)