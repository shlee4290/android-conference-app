package com.survivalcoding.ifkakao.domain.entity

data class Session(
    val title: String,
    val content: String,
    val contentTag: String,
    val company: String,
    val thumbnailUrl: String,
    val video: List<Video>,
    val category: Category,
    val contentsSpeakers: List<Speaker>,
    val isFavorite: Boolean,
    val exposureDay: Int,
)