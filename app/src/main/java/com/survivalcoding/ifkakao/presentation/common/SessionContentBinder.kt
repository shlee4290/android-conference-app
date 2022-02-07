package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class SessionContentBinder(val content: String) : CommonBinder {

    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as SessionContentBinder
        newItem as SessionContentBinder

        return oldItem.content == newItem.content
    }

    companion object {
        const val ID = R.layout.session_content
    }
}