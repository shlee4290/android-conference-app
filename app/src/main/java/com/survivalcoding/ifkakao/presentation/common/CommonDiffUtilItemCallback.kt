package com.survivalcoding.ifkakao.presentation.common

import androidx.recyclerview.widget.DiffUtil

class CommonDiffUtilItemCallback : DiffUtil.ItemCallback<CommonBinder>() {
    override fun areItemsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        return oldItem.areContentsTheSame(oldItem, newItem)
    }
}