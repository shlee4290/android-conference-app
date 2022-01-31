package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.domain.entity.Category

class CategoryListBinder(val category: Category) : CommonBinder {

    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as CategoryListBinder
        newItem as CategoryListBinder

        return oldItem.category == newItem.category
    }

    companion object {
        const val ID = R.layout.category_list
    }
}