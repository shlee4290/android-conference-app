package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.domain.entity.Session

class SessionBinder(val session: Session) : CommonBinder {
    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as SessionBinder
        newItem as SessionBinder

        return oldItem.session == newItem.session
    }

    companion object {
        const val ID = R.layout.session_list_item
    }
}