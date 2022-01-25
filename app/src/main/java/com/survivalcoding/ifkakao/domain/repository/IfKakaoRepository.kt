package com.survivalcoding.ifkakao.domain.repository

import com.survivalcoding.ifkakao.domain.entity.Session

interface IfKakaoRepository {
    suspend fun getAllSessions(): List<Session>
}