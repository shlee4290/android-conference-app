package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.domain.entity.Speaker

class SpeakerBinder(val speaker: Speaker) : CommonBinder {

    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as SpeakerBinder
        newItem as SpeakerBinder

        return oldItem == newItem
    }

    companion object {
        const val ID = R.layout.speaker_profile
    }
}