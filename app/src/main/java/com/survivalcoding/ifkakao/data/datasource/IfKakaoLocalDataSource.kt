package com.survivalcoding.ifkakao.data.datasource

interface IfKakaoLocalDataSource {
    suspend fun addFavorite()
    suspend fun removeFavorite()
    suspend fun getAllFavorite(): List<Int>
}