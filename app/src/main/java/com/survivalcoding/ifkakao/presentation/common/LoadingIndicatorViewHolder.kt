package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.LoadingIndicatorBinding

class LoadingIndicatorViewHolder private constructor(private val binding: LoadingIndicatorBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {}

    companion object {
        fun from(parent: ViewGroup): LoadingIndicatorViewHolder {
            return LoadingIndicatorViewHolder(
                LoadingIndicatorBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
        }
    }
}