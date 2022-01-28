package com.survivalcoding.ifkakao.presentation.common

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class CommonAdapter : ListAdapter<CommonBinder, CommonViewHolder>(CommonDiffUtilItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        return when (viewType) {
            SessionBinder.ID -> SessionViewHolder.from(parent)
            SessionListBinder.ID -> SessionListViewHolder.from(parent)
            else -> FooterViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return currentList[position].id
    }
}