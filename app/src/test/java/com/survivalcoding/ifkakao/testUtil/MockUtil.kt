package com.survivalcoding.ifkakao.testUtil

import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.entity.Speaker
import com.survivalcoding.ifkakao.domain.entity.Video

object MockUtil {
    fun mockSessions() = listOf(
        Session(
            title = "1",
            content = "1",
            contentTag = "#1",
            company = "카카오",
            thumbnailUrl = "",
            video = listOf(Video("", "")),
            category = Category(
                field = listOf("서비스"),
                business = listOf("플랫폼"),
                tech = listOf("데이터"),
                company = listOf("카카오")
            ),
            contentsSpeakers = listOf(Speaker("", "김", "Kim", "", "")),
            isFavorite = false,
            exposureDay = 1
        ),
        Session(
            title = "11",
            content = "11",
            contentTag = "#11",
            company = "카카오",
            thumbnailUrl = "",
            video = listOf(Video("", "")),
            category = Category(
                field = listOf("서비스"),
                business = listOf(),
                tech = listOf(),
                company = listOf()
            ),
            contentsSpeakers = listOf(Speaker("", "김", "Kim", "", "")),
            isFavorite = false,
            exposureDay = 1
        ),
        Session(
            title = "2",
            content = "2",
            contentTag = "#2",
            company = "카카오",
            thumbnailUrl = "",
            video = listOf(Video("", "")),
            category = Category(
                field = listOf(),
                business = listOf("플랫폼"),
                tech = listOf(),
                company = listOf()
            ),
            contentsSpeakers = listOf(Speaker("", "김", "Kim", "", "")),
            isFavorite = false,
            exposureDay = 2
        ),
        Session(
            title = "22",
            content = "22",
            contentTag = "#22",
            company = "카카오",
            thumbnailUrl = "",
            video = listOf(Video("", "")),
            category = Category(
                field = listOf(),
                business = listOf(),
                tech = listOf("데이터"),
                company = listOf()
            ),
            contentsSpeakers = listOf(Speaker("", "김", "Kim", "", "")),
            isFavorite = false,
            exposureDay = 2
        ),
        Session(
            title = "3",
            content = "3",
            contentTag = "#3",
            company = "카카오",
            thumbnailUrl = "",
            video = listOf(Video("", "")),
            category = Category(
                field = listOf(),
                business = listOf(),
                tech = listOf(),
                company = listOf("카카오")
            ),
            contentsSpeakers = listOf(Speaker("", "김", "Kim", "", "")),
            isFavorite = false,
            exposureDay = 3
        ),
        Session(
            title = "33",
            content = "33",
            contentTag = "#33",
            company = "카카오",
            thumbnailUrl = "",
            video = listOf(Video("", "")),
            category = Category(
                field = listOf(),
                business = listOf(),
                tech = listOf(),
                company = listOf()
            ),
            contentsSpeakers = listOf(Speaker("", "김", "Kim", "", "")),
            isFavorite = false,
            exposureDay = 3
        ),
    )
}