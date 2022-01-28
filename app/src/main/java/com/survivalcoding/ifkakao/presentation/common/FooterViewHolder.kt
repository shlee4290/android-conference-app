package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.FooterBinding

class FooterViewHolder private constructor(
    private val binding: FooterBinding,
    private val recyclerView: RecyclerView?
) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as FooterBinder
        binding.arrowButton.setOnClickListener {
            recyclerView?.scrollToPosition(0)
        }
    }

    companion object {
        fun from(parent: ViewGroup, recyclerView: RecyclerView?): FooterViewHolder {
            return FooterViewHolder(
                FooterBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                recyclerView
            )
        }
    }
}