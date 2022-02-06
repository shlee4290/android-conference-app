package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.datasource.IfKakaoLocalDataSource
import com.survivalcoding.ifkakao.data.datasource.IfKakaoRemoteDataSource
import com.survivalcoding.ifkakao.domain.entity.Categories
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

    override suspend fun getAllCategories(): Categories {
        val field = mutableSetOf<Category.Field>()
        val business = mutableSetOf<Category.Business>()
        val tech = mutableSetOf<Category.Tech>()
        val company = mutableSetOf<Category.Company>()

        getAllSessions().forEach {
            field.addAll(it.categories.field)
            business.addAll(it.categories.business)
            tech.addAll(it.categories.tech)
            company.addAll(it.categories.company)
        }

        return Categories(field.toList(), business.toList(), tech.toList(), company.toList())
    }

    override suspend fun addFavoriteSession(sessionId: Int) {
        ifKakaoLocalDataSourece.addFavoriteSession(sessionId)
    }

    override suspend fun removeFavoriteSession(sessionId: Int) {
        ifKakaoLocalDataSourece.removeFavoriteSession(sessionId)
    }

    override suspend fun getSession(id: Int): Session {
        return getAllSessions().first { it.idx == id }
    }
}