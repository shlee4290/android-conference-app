package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class DrawerSubtitleBinder(val text: String) : CommonBinder {
    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as DrawerSubtitleBinder
        newItem as DrawerSubtitleBinder

        return oldItem.text == newItem.text
    }

    companion object {
        const val ID = R.layout.drawer_subtitle
    }
}