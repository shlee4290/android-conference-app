package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class SessionListBinder(val sessionBinderList: List<SessionBinder>) : CommonBinder {
    override val id: Int = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as SessionListBinder
        newItem as SessionListBinder

        return oldItem.sessionBinderList == newItem.sessionBinderList
    }

    companion object {
        const val ID = R.layout.session_list
    }
}