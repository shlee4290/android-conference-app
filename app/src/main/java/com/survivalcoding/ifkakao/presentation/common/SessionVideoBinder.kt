package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.domain.entity.Video

class SessionVideoBinder(
    val video: Video,
    val thumbnailUrl: String,
    val title: String,
    val onPlayButtonClick: (String) -> Unit,
    val onShareButtonClick: () -> Unit
) : CommonBinder {

    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as SessionVideoBinder
        newItem as SessionVideoBinder

        return oldItem.video == newItem.video
    }

    companion object {
        const val ID = R.layout.session_video
    }
}