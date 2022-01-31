package com.survivalcoding.ifkakao.presentation.common

import android.view.ViewGroup

class SessionListItemViewHolder private constructor(private val sessionListItem: SessionListItemView) :
    CommonViewHolder(sessionListItem) {

    override fun bind(binder: CommonBinder) {
        binder as SessionListItemBinder
        sessionListItem.session = binder.session
        sessionListItem.setOnClickListener { binder.onClick(binder.session) }
    }

    companion object {
        fun from(parent: ViewGroup): SessionListItemViewHolder {
            return SessionListItemViewHolder(
                SessionListItemView(parent.context)
            )
        }
    }
}