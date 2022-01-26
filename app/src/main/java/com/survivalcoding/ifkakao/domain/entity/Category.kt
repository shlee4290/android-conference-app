package com.survivalcoding.ifkakao.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val field: List<String> = listOf(),
    val business: List<String> = listOf(),
    val tech: List<String> = listOf(),
    val company: List<String> = listOf()
) : Parcelable
