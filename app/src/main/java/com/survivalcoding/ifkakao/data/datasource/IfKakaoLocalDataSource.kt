package com.survivalcoding.ifkakao.data.datasource

interface IfKakaoLocalDataSource {
    suspend fun addFavoriteSession(sessionId: Int)
    suspend fun removeFavoriteSession(sessionId: Int)
    suspend fun getAllFavorite(): List<Int>
}