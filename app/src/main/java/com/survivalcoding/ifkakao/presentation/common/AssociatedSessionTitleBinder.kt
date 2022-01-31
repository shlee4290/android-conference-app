package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class AssociatedSessionTitleBinder : CommonBinder {
    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder) = true

    companion object {
        const val ID = R.layout.associated_session_title
    }
}