package com.survivalcoding.ifkakao.data.dto

import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.entity.Speaker
import com.survivalcoding.ifkakao.domain.entity.Video

data class Session(
    val categoryIdx: Int? = null,
    val commentYn: String? = null,
    val company: String? = null,
    val companyName: String? = null,
    val content: String? = null,
    val contentTag: String? = null,
    val contentsSpeakerList: List<ContentsSpeaker>? = null,
    val createdDateTime: String? = null,
    val createdUserIdx: Int? = null,
    val favoriteYn: String? = null,
    val `field`: String? = null,
    val idx: Int? = null,
    val lastModifiedDateTime: String? = null,
    val lastModifiedUserIdx: Int? = null,
    val linkList: LinkList? = null,
    val newCountentsYn: String? = null,
    val relationList: RelationList? = null,
    val reservationDate: String? = null,
    val reservationTime: String? = null,
    val reservationUTC: Long? = null,
    val reservationYn: String? = null,
    val sessionType: String? = null,
    val speakerLoginYn: String? = null,
    val speakerName: String? = null,
    val spotlightYn: String? = null,
    val title: String? = null,
    val updateCountentsYn: String? = null,
    val videoYn: String? = null
)

fun Session.convert(): com.survivalcoding.ifkakao.domain.entity.Session {
    return com.survivalcoding.ifkakao.domain.entity.Session(
        idx = idx ?: 0,
        title = title ?: "",
        content = content ?: "",
        contentTag = contentTag ?: "",
        company = companyName ?: "",
        thumbnailUrl = if (linkList?.PC_IMAGE.isNullOrEmpty()) "" else linkList?.PC_IMAGE?.first()?.url
            ?: "",
        video = linkList?.VIDEO?.map { Video(it.url ?: "", it.description ?: "") } ?: listOf(),
        category = Category(
            field = if (field != null) listOf(field) else listOf(),
            business = relationList?.CLASSIFICATION ?: listOf(),
            tech = relationList?.TECH_CLASSIFICATION ?: listOf(),
            company = if (company != null) listOf(company) else listOf()
        ),
        contentsSpeakers = contentsSpeakerList?.zip(linkList?.SPEAKER_PROFILE ?: listOf())?.map {
            Speaker(
                profileUrl = it.second.url ?: "",
                nameEn = it.first.nameEn ?: "",
                nameKo = it.first.nameKo ?: "",
                company = it.first.company ?: "",
                occupation = it.first.occupation ?: ""
            )
        } ?: listOf(),
        isHighlight = spotlightYn?.lowercase() == "y",
        isFavorite = false,
        exposureDay = if (relationList?.MAIN_EXPOSURE_DAY.isNullOrEmpty()) 3 else relationList?.MAIN_EXPOSURE_DAY?.first()
            ?.substringBefore("Day")?.toInt() ?: 3
    )
}

fun List<Session>.convert(): List<com.survivalcoding.ifkakao.domain.entity.Session> {
    return map { it.convert() }
}