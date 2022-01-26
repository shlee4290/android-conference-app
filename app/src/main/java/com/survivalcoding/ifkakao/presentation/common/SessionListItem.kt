package com.survivalcoding.ifkakao.presentation.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.survivalcoding.ifkakao.databinding.SessionListItemBinding

class SessionListItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: SessionListItemBinding by lazy {
        SessionListItemBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        binding.companyBadge.isHighlight = true
        binding.companyBadge.text = "카카오"

        binding.categoryBadge.isHighlight = false
        binding.categoryBadge.text = "기술"

        binding.thumbnail.description = "55:11"
        binding.thumbnail.thumbnailUrl = ""

        binding.titleTextView.text = "이용자의 소중한 일상을 지키는 카카오톡"
    }

}