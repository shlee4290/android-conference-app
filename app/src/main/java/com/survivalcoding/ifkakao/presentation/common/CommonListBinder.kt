package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class CommonListBinder(val commonBinderList: List<CommonBinder>) : CommonBinder {
    override val id: Int = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as CommonListBinder
        newItem as CommonListBinder

        return oldItem.commonBinderList == newItem.commonBinderList
    }

    companion object {
        const val ID = R.layout.common_list
    }
}