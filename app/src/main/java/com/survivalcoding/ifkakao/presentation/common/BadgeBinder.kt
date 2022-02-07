package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.domain.entity.Category

class BadgeBinder(
    val category: Category,
    val isHighlight: Boolean,
    val isBig: Boolean,
    val onClick: (Category) -> Unit
) : CommonBinder {
    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as BadgeBinder
        newItem as BadgeBinder

        return oldItem.category == newItem.category && oldItem.isBig == newItem.isBig && oldItem.isHighlight == newItem.isHighlight
    }

    companion object {
        const val ID = R.layout.badge
    }
}