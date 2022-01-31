package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.survivalcoding.ifkakao.databinding.SessionVideoBinding

class SessionVideoViewHolder private constructor(private val binding: SessionVideoBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as SessionVideoBinder

        Glide.with(binding.root)
            .load(binder.thumbnailUrl)
            .into(binding.sessionThumbnailImage)

        binding.shareButton.setOnClickListener { binder.onShareButtonClick() }
        binding.titleTextView.text = binder.title

        if (binder.video.length.isNotBlank()) {
            binding.playButton.visibility = View.VISIBLE
            binding.descriptionTextView.visibility = View.VISIBLE
            binding.descriptionTextView.text = binder.video.url
            binding.playButton.setOnClickListener { binder.onPlayButtonClick(binder.video.url) }
        } else {
            binding.playButton.visibility = View.INVISIBLE
            binding.descriptionTextView.visibility = View.INVISIBLE
        }
    }

    companion object {
        fun from(parent: ViewGroup): SessionVideoViewHolder {
            return SessionVideoViewHolder(
                SessionVideoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}