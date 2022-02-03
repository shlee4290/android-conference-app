package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.DrawerTitleBinding

class DrawerTitleViewHolder private constructor(private val binding: DrawerTitleBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as DrawerTitleBinder
        binding.textView.text = binder.text
    }

    companion object {
        fun from(parent: ViewGroup): DrawerTitleViewHolder {
            return DrawerTitleViewHolder(
                DrawerTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}