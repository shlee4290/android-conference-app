package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.SessionButtonBinding

class SessionButtonViewHolder private constructor(private val binding: SessionButtonBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as SessionButtonBinder

        binding.button.text = binder.text
        binding.button.setOnClickListener { binder.onClick() }
    }

    companion object {
        fun from(parent: ViewGroup): SessionButtonViewHolder {
            return SessionButtonViewHolder(
                SessionButtonBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}