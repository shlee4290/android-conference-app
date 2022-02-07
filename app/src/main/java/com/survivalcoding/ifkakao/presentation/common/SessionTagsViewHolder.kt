package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.SessionTagsBinding

class SessionTagsViewHolder private constructor(private val binding: SessionTagsBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as SessionTagsBinder
        binding.tagsTextView.text = binder.tags
    }

    companion object {
        fun from(parent: ViewGroup): SessionTagsViewHolder {
            return SessionTagsViewHolder(
                SessionTagsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }
}