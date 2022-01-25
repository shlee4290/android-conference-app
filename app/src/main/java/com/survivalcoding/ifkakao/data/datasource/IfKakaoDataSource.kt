package com.survivalcoding.ifkakao.data.datasource

import com.survivalcoding.ifkakao.domain.entity.Session

interface IfKakaoDataSource {
    suspend fun getAllSessions(): List<Session>
}