package com.survivalcoding.ifkakao.presentation.common

import android.view.ViewGroup

class SessionViewHolder private constructor(private val sessionListItem: SessionListItem) :
    CommonViewHolder(sessionListItem) {

    override fun bind(binder: CommonBinder) {
        binder as SessionBinder
        sessionListItem.session = binder.session
    }

    companion object {
        fun from(parent: ViewGroup): SessionViewHolder {
            return SessionViewHolder(
                SessionListItem(parent.context)
            )
        }
    }
}