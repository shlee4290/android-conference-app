package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.SessionListBinding

class SessionListViewHolder private constructor(private val binding: SessionListBinding) :
    CommonViewHolder(binding.root) {
    override fun bind(binder: CommonBinder) {
        binder as SessionListBinder
        (binding.recyclerView.adapter as CommonAdapter).submitList(binder.sessionBinderList)
    }

    companion object {
        fun from(parent: ViewGroup): SessionListViewHolder {
            return SessionListViewHolder(
                SessionListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                    .apply {
                        this.recyclerView.adapter = CommonAdapter()
                    }
            )
        }
    }
}