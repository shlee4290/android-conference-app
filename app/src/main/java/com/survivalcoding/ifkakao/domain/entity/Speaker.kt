package com.survivalcoding.ifkakao.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Speaker(
    val profileUrl: String,
    val nameKo: String,
    val nameEn: String,
    val company: String,
    val occupation: String
): Parcelable
