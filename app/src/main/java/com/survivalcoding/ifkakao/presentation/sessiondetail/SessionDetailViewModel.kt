package com.survivalcoding.ifkakao.presentation.sessiondetail

import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.presentation.common.CommonBinder
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SessionDetailViewModel @Inject constructor(): ViewModel() {
    var session: Session? = null

    val binderList: List<CommonBinder>
        get() {
            val tmpBinderList = mutableListOf<CommonBinder>()

            // TODO

            return tmpBinderList
        }
}