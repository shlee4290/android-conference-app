package com.survivalcoding.ifkakao.domain.entity

data class Category(
    val field: List<String> = listOf(),
    val business: List<String> = listOf(),
    val tech: List<String> = listOf(),
    val company: List<String> = listOf()
)
