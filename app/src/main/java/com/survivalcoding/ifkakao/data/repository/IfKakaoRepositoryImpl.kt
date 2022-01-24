package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.datasource.IfKakaoDataSource
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository

class IfKakaoRepositoryImpl constructor(private val ifKakaoDataSource: IfKakaoDataSource) :
    IfKakaoRepository {
    override suspend fun getAllSessions(): List<Session> = ifKakaoDataSource.getAllSessions()
}