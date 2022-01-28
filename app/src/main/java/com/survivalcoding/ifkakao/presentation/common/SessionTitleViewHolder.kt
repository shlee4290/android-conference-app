package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.SessionTitleBinding

class SessionTitleViewHolder private constructor(private val binding: SessionTitleBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as SessionTitleBinder
        binding.titleTextView.text = binder.title
    }

    companion object {
        fun from(parent: ViewGroup): SessionTitleViewHolder {
            return SessionTitleViewHolder(
                SessionTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}