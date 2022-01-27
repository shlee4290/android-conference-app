package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.datasource.IfKakaoLocalDataSource
import com.survivalcoding.ifkakao.data.datasource.IfKakaoRemoteDataSource
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import javax.inject.Inject

class IfKakaoRepositoryImpl @Inject constructor(
    private val ifKakaoRemoteDataSource: IfKakaoRemoteDataSource,
    private val ifKakaoLocalDataSourece: IfKakaoLocalDataSource
) : IfKakaoRepository {

    override suspend fun getAllSessions(): List<Session> =
        ifKakaoRemoteDataSource.getAllSessions().map {
            if (it.idx in ifKakaoLocalDataSourece.getAllFavorite()) {
                it.copy(isFavorite = true)
            } else {
                it
            }
        }

    override suspend fun addFavoriteSession(sessionId: Int) {
        ifKakaoLocalDataSourece.addFavoriteSession(sessionId)
    }

    override suspend fun removeFavoriteSession(sessionId: Int) {
        ifKakaoLocalDataSourece.removeFavoriteSession(sessionId)
    }
}