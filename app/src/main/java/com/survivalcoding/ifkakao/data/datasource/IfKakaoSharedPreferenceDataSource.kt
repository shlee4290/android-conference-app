package com.survivalcoding.ifkakao.data.datasource

import javax.inject.Inject

class IfKakaoSharedPreferenceDataSource @Inject constructor() : IfKakaoLocalDataSource {
    override suspend fun addFavorite() {
        TODO("Not yet implemented")
    }

    override suspend fun removeFavorite() {
        TODO("Not yet implemented")
    }

    override suspend fun getAllFavorite(): List<Int> {
        TODO("Not yet implemented")
    }
}