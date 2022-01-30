package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.domain.entity.Category

class CategoryBinder(private val category: Category) : CommonBinder {

    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        TODO("Not yet implemented")
    }

    companion object {
        const val ID = 1 // TODO
    }
}