package com.survivalcoding.ifkakao.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.survivalcoding.ifkakao.databinding.SessionLinksBinding

class SessionLinksViewHolder private constructor(private val binding: SessionLinksBinding) :
    CommonViewHolder(binding.root) {

    override fun bind(binder: CommonBinder) {
        binder as SessionLinksBinder

        binding.kakaotalkShareButton.setOnClickListener {
            binder.onClickTalk()
        }
        binding.facebookShareButton.setOnClickListener {
            binder.onClickFacebook()
        }
        binding.twitterShareButton.setOnClickListener {
            binder.onClickTwit()
        }
        binding.linkShareButton.setOnClickListener {
            binder.onClickShare()
        }
    }

    companion object {
        fun from(parent: ViewGroup): SessionLinksViewHolder {
            return SessionLinksViewHolder(
                SessionLinksBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}