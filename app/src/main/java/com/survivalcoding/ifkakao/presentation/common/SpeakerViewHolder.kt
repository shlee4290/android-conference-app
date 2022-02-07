package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.SpeakerProfileBinding

class SpeakerViewHolder private constructor(private val binding: SpeakerProfileBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as SpeakerBinder
        binding.companyTextView.text = binder.speaker.company
        if (binder.speaker.company.isBlank()) binding.companyTextView.visibility = View.GONE
        else binding.companyTextView.visibility = View.VISIBLE

        binding.speakerNameTextView.text = "${binder.speaker.nameKo} ${binder.speaker.nameEn}"
        binding.roleTextView.text = binder.speaker.occupation
        binding.speakerProfileImageView.profileImageUrl = binder.speaker.profileUrl
    }

    companion object {
        fun from(parent: ViewGroup): SpeakerViewHolder {
            return SpeakerViewHolder(
                SpeakerProfileBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}