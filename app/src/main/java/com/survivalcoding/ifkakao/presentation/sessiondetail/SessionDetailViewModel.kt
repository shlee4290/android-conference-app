package com.survivalcoding.ifkakao.presentation.sessiondetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.entity.Session
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
    private val getSelectedSessionsUseCase: GetSelectedSessionsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SessionDetailUiState(listOf()))
    val uiState = _uiState.asStateFlow()

    private var session: Session? = null

    fun setSession(session: Session) {
        this.session = session
        refreshBinderList(session)
    }

    private fun refreshBinderList(session: Session) {
        viewModelScope.launch {
            val fieldCategory = if (session.category.field.isNotEmpty()) {
                session.category.field.first()
            } else {
                ""
            }

            val relatedSessions = async {
                getSelectedSessionsUseCase(category = Category(field = listOf(fieldCategory)))
            }

            val tmpBinderList = mutableListOf<CommonBinder>()

            if (session.video.isNotEmpty()) {
                tmpBinderList.add(
                    SessionVideoBinder(
                        session.video.first(),
                        session.thumbnailUrl,
                        session.title,
                        {},// TODO
                        {}// TODO
                    )
                )
            }
            tmpBinderList.add(CategoryListBinder(session.category))
            tmpBinderList.add(SessionTitleBinder(session.title))
            tmpBinderList.add(SessionContentBinder(session.content))
            tmpBinderList.add(SessionTagsBinder(session.contentTag))
            tmpBinderList.addAll(
                session.contentsSpeakers.map {
                    SpeakerBinder(it)
                }
            )
            tmpBinderList.addAll(
                relatedSessions.await().filter { it.idx != session.idx }
                    .map { SessionListItemBinder(it, {}) } // TODO
            )
            tmpBinderList.add(FooterBinder())

            _uiState.value = _uiState.value.copy(binderList = tmpBinderList)
        }
    }

}

data class SessionDetailUiState(
    val binderList: List<CommonBinder>
)