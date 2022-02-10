package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.domain.entity.Video

class SessionThumbnailBinder(
    val video: Video,
    val thumbnailUrl: String,
    val title: String,
    val onPlayButtonClick: (String) -> Unit,
    val onShareButtonClick: () -> Unit
) : CommonBinder {

    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as SessionThumbnailBinder
        newItem as SessionThumbnailBinder

        return oldItem.video == newItem.video
    }

    companion object {
        const val ID = R.layout.session_thumbnail
    }
}