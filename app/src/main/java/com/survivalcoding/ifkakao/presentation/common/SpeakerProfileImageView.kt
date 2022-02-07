package com.survivalcoding.ifkakao.presentation.common

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.survivalcoding.ifkakao.databinding.SpeakerProfileImageBinding

class SpeakerProfileImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: SpeakerProfileImageBinding by lazy {
        SpeakerProfileImageBinding.inflate(LayoutInflater.from(context), this, true)
    }

    var profileImageUrl: String = ""
        set(value) {
            field = value

            if (profileImageUrl.isBlank()) return

            val uri = Uri.parse(field)
            Glide.with(binding.root)
                .load(uri)
                .centerCrop()
                .into(binding.profileImageView)
        }
}