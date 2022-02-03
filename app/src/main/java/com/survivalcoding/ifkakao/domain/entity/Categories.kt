package com.survivalcoding.ifkakao.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Categories(
    val field: List<Category.Field> = listOf(),
    val business: List<Category.Business> = listOf(),
    val tech: List<Category.Tech> = listOf(),
    val company: List<Category.Company> = listOf()
) : Parcelable

fun Categories.toList(): List<Category> {
    val categoryList = mutableListOf<Category>()
    categoryList.addAll(field)
    categoryList.addAll(company)
    categoryList.addAll(business)
    categoryList.addAll(tech)

    return categoryList
}

sealed class Category {

    abstract val text: String

    @Parcelize
    data class Field(override val text: String) : Category(), Parcelable

    @Parcelize
    data class Company(override val text: String) : Category(), Parcelable

    @Parcelize
    data class Business(override val text: String) : Category(), Parcelable

    @Parcelize
    data class Tech(override val text: String) : Category(), Parcelable
}