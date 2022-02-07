package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.KeywordToggleBinding

class KeywordToggleViewHolder private constructor(private val binding: KeywordToggleBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as KeywordToggleBinder

        binding.toggleButton.text = binder.category.text
        binding.toggleButton.textOn = binder.category.text
        binding.toggleButton.textOff = binder.category.text
        binding.toggleButton.setOnCheckedChangeListener { _, isChecked ->
            binder.onCheckedChange(isChecked, binder.category)
        }
        binding.toggleButton.isChecked = binder.category in binder.selectedCategories
    }

    companion object {
        fun from(parent: ViewGroup): KeywordToggleViewHolder {
            return KeywordToggleViewHolder(
                KeywordToggleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}