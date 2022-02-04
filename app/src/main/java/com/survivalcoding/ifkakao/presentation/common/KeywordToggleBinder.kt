package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.domain.entity.Category

class KeywordToggleBinder(
    val category: Category,
    val selectedCategories: Set<Category>,
    val onCheckedChange: (Boolean, Category) -> Unit
) : CommonBinder {
    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder) = false

    companion object {
        const val ID = R.layout.keyword_toggle
    }
}