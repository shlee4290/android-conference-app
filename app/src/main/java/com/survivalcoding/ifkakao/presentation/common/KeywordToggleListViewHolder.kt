package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.KeywordToggleListBinding

class KeywordToggleListViewHolder private constructor(private val binding: KeywordToggleListBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as KeywordToggleListBinder
        (binding.recyclerView.adapter as CommonAdapter).submitList(binder.keywordToggleBinderList)
    }

    companion object {
        fun from(parent: ViewGroup): KeywordToggleListViewHolder {
            val binding =
                KeywordToggleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                    .apply {
                        this.recyclerView.adapter = CommonAdapter()
                    }

            return KeywordToggleListViewHolder(binding)
        }
    }
}