package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.FooterBinding

class FooterViewHolder private constructor(private val binding: FooterBinding) : CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as FooterBinder
        binding.arrowButton.setOnClickListener {
            binder.arrowButtonCallback()
        }
    }

    companion object {
        fun from(parent: ViewGroup): FooterViewHolder {
            return FooterViewHolder(
                FooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }
}