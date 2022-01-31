package com.survivalcoding.ifkakao.presentation.common

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.ThumbnailBinding

class ThumbnailView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ThumbnailBinding by lazy {
        ThumbnailBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        binding.root.clipToOutline = true
    }

    var description: String = ""
        set(value) {
            field = value
            if (value.isBlank()) {
                binding.descriptionTextView.visibility = GONE
                binding.descriptionTextView.setBackgroundColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.transparent,
                        null
                    )
                )
            } else {
                binding.descriptionTextView.visibility = VISIBLE
                binding.descriptionTextView.setBackgroundColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.thumbnail_description_background_color,
                        null
                    )
                )
                binding.descriptionTextView.text = value
            }
        }

    var thumbnailUrl: String = ""
        set(value) {
            field = value
            val uri = Uri.parse(field)
            Glide.with(binding.root)
                .load(uri)
                .centerCrop()
                .into(binding.thumbnailImageView)
        }

}