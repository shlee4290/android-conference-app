package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class BadgeBinder(
    val text: String,
    val isHighlight: Boolean,
    val isBig: Boolean
) : CommonBinder {
    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as BadgeBinder
        newItem as BadgeBinder

        return oldItem.text == newItem.text && oldItem.isBig == newItem.isBig && oldItem.isHighlight == newItem.isHighlight
    }

    companion object {
        const val ID = R.layout.badge
    }
}