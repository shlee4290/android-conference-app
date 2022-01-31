package com.survivalcoding.ifkakao.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Session(
    val idx: Int,
    val title: String,
    val content: String,
    val contentTag: String,
    val company: String,
    val thumbnailUrl: String,
    val video: List<Video>,
    val category: Category,
    val contentsSpeakers: List<Speaker>,
    val isHighlight: Boolean,
    val isFavorite: Boolean,
    val exposureDay: Int,
) : Parcelable

fun Session.toList(): List<String> {
    val categoryList = mutableListOf<String>()
    categoryList.addAll(category.field)
    categoryList.addAll(category.company)
    categoryList.addAll(category.business)
    categoryList.addAll(category.tech)

    return categoryList
}