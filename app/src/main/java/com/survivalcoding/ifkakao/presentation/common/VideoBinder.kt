package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.domain.entity.Video

class VideoBinder (private val video: Video, private val thumbnail: Thumbnail) : CommonBinder {

    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        TODO("Not yet implemented")
    }

    companion object {
        const val ID = 1 // TODO
    }
}