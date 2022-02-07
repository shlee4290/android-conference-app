package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.SessionContentBinding

class SessionContentViewHolder private constructor(private val binding: SessionContentBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as SessionContentBinder
        binding.contentTextView.text = binder.content
    }

    companion object {
        fun from(parent: ViewGroup): SessionContentViewHolder {
            return SessionContentViewHolder(
                SessionContentBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}