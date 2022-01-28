package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class SessionTagsBinder(val tags: String) : CommonBinder {

    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as SessionTagsBinder
        newItem as SessionTagsBinder

        return oldItem.tags == newItem.tags
    }

    companion object {
        const val ID = R.layout.session_tags
    }
}