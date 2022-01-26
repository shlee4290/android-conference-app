package com.survivalcoding.ifkakao.presentation.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.presentation.common.SessionListItem

class SessionViewHolder private constructor(private val sessionListItem: SessionListItem) :
    RecyclerView.ViewHolder(sessionListItem) {

    fun bind(session: Session) {
        sessionListItem.session = session
    }

    companion object {
        fun from(parent: ViewGroup): SessionViewHolder {
            return SessionViewHolder(
                SessionListItem(parent.context)
            )
        }
    }
}