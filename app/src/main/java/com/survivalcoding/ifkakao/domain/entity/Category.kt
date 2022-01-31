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

fun Category.toList(): List<String> {
    val categoryList = mutableListOf<String>()
    categoryList.addAll(field)
    categoryList.addAll(company)
    categoryList.addAll(business)
    categoryList.addAll(tech)

    return categoryList
}
