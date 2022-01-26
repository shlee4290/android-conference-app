package com.survivalcoding.ifkakao.presentation.main

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.domain.entity.Session

class SessionDiffUtilItemCallback: DiffUtil.ItemCallback<Session>() {
    override fun areItemsTheSame(oldItem: Session, newItem: Session) = oldItem.idx == newItem.idx

    override fun areContentsTheSame(oldItem: Session, newItem: Session) = oldItem == newItem
}