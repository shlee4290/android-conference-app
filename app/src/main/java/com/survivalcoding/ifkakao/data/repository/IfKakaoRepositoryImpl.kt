package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.datasource.IfKakaoLocalDataSource
import com.survivalcoding.ifkakao.data.datasource.IfKakaoRemoteDataSource
import com.survivalcoding.ifkakao.domain.entity.Category
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

    override suspend fun getAllCategories(): Category {
        val field = mutableSetOf<String>()
        val business = mutableSetOf<String>()
        val tech = mutableSetOf<String>()
        val company = mutableSetOf<String>()

        getAllSessions().forEach {
            field.addAll(it.category.field)
            business.addAll(it.category.business)
            tech.addAll(it.category.tech)
            company.addAll(it.category.company)
        }

        return Category(field.toList(), business.toList(), tech.toList(), company.toList())
    }

    override suspend fun addFavoriteSession(sessionId: Int) {
        ifKakaoLocalDataSourece.addFavoriteSession(sessionId)
    }

    override suspend fun removeFavoriteSession(sessionId: Int) {
        ifKakaoLocalDataSourece.removeFavoriteSession(sessionId)
    }
}