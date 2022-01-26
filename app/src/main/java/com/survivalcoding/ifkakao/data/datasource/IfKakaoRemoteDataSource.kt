package com.survivalcoding.ifkakao.data.datasource

import com.survivalcoding.ifkakao.domain.entity.Session

interface IfKakaoRemoteDataSource {
    suspend fun getAllSessions(): List<Session>
}