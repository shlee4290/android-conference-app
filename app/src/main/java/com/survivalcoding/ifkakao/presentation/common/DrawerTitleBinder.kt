package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class DrawerTitleBinder(val text: String) : CommonBinder {
    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as DrawerTitleBinder
        newItem as DrawerTitleBinder

        return oldItem.text == newItem.text
    }

    companion object {
        const val ID = R.layout.drawer_title
    }
}