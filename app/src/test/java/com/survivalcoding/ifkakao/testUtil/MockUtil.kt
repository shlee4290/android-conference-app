package com.survivalcoding.ifkakao.testUtil

import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.entity.Speaker
import com.survivalcoding.ifkakao.domain.entity.Video

class MockIfKakaoSessionsBuilder {

    private var index = 1
    private val mockSessions = mutableListOf<Session>()

    fun build() = mockSessions

    fun addSession(
        company: String = "카카오",
        content: String = "",
        contentTag: String = "",
        title: String = "",
        thumbnailUrl: String = "",
        videos: List<Video> = listOf(),
        category: Category = Category(),
        contentsSpeakers: List<Speaker> = listOf(),
        isHighlight: Boolean = false,
        isFavorite: Boolean = false,
        exposureDay: Int = 3
    ): MockIfKakaoSessionsBuilder {
        mockSessions.add(
            Session(
                idx = index++,
                company = company,
                content = content,
                contentTag = contentTag,
                title = title,
                thumbnailUrl = thumbnailUrl,
                video = videos,
                category = category,
                contentsSpeakers = contentsSpeakers,
                isHighlight = isHighlight,
                isFavorite = isFavorite,
                exposureDay = exposureDay
            )
        )

        return this
    }

    fun shuffle(): MockIfKakaoSessionsBuilder {
        mockSessions.shuffle()

        return this
    }
}
