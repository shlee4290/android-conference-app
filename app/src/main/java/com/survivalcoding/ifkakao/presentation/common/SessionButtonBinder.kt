package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class SessionButtonBinder(val text: String, val onClick: () -> Unit) : CommonBinder {
    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as SessionButtonBinder
        newItem as SessionButtonBinder

        return oldItem.text == newItem.text && oldItem.onClick == newItem.onClick
    }

    companion object {
        const val ID = R.layout.session_button
    }
}