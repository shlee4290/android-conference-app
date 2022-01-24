package com.survivalcoding.ifkakao.domain.repository

import com.survivalcoding.ifkakao.domain.entity.Session

interface IfKakaoRepository {
    fun getAllSessions(): List<Session>
}