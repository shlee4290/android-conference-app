package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.survivalcoding.ifkakao.databinding.SessionThumbnailBinding

class SessionThumbnailViewHolder private constructor(private val binding: SessionThumbnailBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as SessionThumbnailBinder

        Glide.with(binding.root)
            .load(binder.thumbnailUrl)
            .into(binding.sessionThumbnailImage)

        binding.shareButton.setOnClickListener { binder.onShareButtonClick() }
        binding.titleTextView.text = binder.title
        binding.playButton.setOnClickListener { binder.onPlayButtonClick(binder.video.url) }

        if (binder.video.length.isNotBlank()) {
            binding.descriptionTextView.text = binder.video.length
        } else {
            binding.descriptionTextView.text = "참가하기"
        }
    }

    companion object {
        fun from(parent: ViewGroup): SessionThumbnailViewHolder {
            return SessionThumbnailViewHolder(
                SessionThumbnailBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}