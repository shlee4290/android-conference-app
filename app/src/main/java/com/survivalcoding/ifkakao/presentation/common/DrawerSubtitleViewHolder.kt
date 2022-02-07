package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.DrawerSubtitleBinding

class DrawerSubtitleViewHolder private constructor(private val binding: DrawerSubtitleBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as DrawerSubtitleBinder
        binding.textView.text = binder.text
    }

    companion object {
        fun from(parent: ViewGroup): DrawerSubtitleViewHolder {
            return DrawerSubtitleViewHolder(
                DrawerSubtitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}