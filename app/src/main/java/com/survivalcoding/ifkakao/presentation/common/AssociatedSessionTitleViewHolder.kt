package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.AssociatedSessionTitleBinding

class AssociatedSessionTitleViewHolder private constructor(private val binding: AssociatedSessionTitleBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {}

    companion object {
        fun from(parent: ViewGroup): AssociatedSessionTitleViewHolder {
            return AssociatedSessionTitleViewHolder(
                AssociatedSessionTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}