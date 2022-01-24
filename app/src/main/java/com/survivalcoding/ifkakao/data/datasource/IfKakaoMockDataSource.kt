package com.survivalcoding.ifkakao.data.datasource

import com.survivalcoding.ifkakao.domain.entity.Session

class IfKakaoMockDataSource : IfKakaoDataSource {

    val sessions: List<Session>? = null

    override suspend fun getAllSessions(): List<Session> {
        return sessions ?: listOf()
    }
}