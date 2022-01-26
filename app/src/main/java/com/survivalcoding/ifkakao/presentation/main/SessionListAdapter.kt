package com.survivalcoding.ifkakao.presentation.main

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.domain.entity.Session

class SessionListAdapter : ListAdapter<Session, SessionViewHolder>(SessionDiffUtilItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SessionViewHolder.from(parent)

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}