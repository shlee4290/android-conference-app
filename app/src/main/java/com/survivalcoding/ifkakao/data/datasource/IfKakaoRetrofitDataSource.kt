package com.survivalcoding.ifkakao.data.datasource

import com.survivalcoding.ifkakao.domain.entity.Session
import javax.inject.Inject

class IfKakaoRetrofitDataSource @Inject constructor() : IfKakaoRemoteDataSource {

    private val sessions: List<Session>? = null

    override suspend fun getAllSessions(): List<Session> {
        return sessions ?: listOf()
    }
}