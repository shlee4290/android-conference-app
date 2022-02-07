package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class FooterBinder () : CommonBinder {
    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as FooterBinder
        newItem as FooterBinder
        return oldItem == newItem
    }

    companion object {
        const val ID = R.layout.footer
    }
}