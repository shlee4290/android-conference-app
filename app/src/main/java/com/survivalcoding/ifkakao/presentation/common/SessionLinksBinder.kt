package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class SessionLinksBinder(
    val onClickTalk: () -> Unit,
    val onClickFacebook: () -> Unit,
    val onClickTwit: () -> Unit,
    val onClickShare: () -> Unit,
) : CommonBinder {

    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder) = true

    companion object {
        const val ID = R.layout.session_links
    }
}