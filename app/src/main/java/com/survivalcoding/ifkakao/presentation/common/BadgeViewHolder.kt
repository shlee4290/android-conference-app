package com.survivalcoding.ifkakao.presentation.common

import android.view.ViewGroup

class BadgeViewHolder private constructor(private val badgeView: BadgeView) :
    CommonViewHolder(badgeView) {

    override fun bind(binder: CommonBinder) {
        binder as BadgeBinder
        badgeView.text = binder.text
        badgeView.isHighlight = binder.isHighlight
        badgeView.isBig = binder.isBig
    }

    companion object {
        fun from(parent: ViewGroup): BadgeViewHolder {
            return BadgeViewHolder(BadgeView(parent.context))
        }
    }
}