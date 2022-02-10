package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class LoadingIndicatorBinder: CommonBinder {
    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder) = true

    companion object {
        const val ID = R.layout.loading_indicator
    }
}