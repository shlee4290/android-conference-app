package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class SessionTitleBinder(val title: String) : CommonBinder {

    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as SessionTitleBinder
        newItem as SessionTitleBinder

        return oldItem.title == newItem.title
    }

    companion object {
        const val ID = R.layout.session_title
    }
}