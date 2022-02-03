package com.survivalcoding.ifkakao.domain.repository

import com.survivalcoding.ifkakao.domain.entity.Categories
import com.survivalcoding.ifkakao.domain.entity.Session

interface IfKakaoRepository {
    suspend fun getAllSessions(): List<Session>
    suspend fun addFavoriteSession(sessionId: Int)
    suspend fun removeFavoriteSession(sessionId: Int)
    suspend fun getAllCategories(): Categories
}