package com.survivalcoding.ifkakao.data.datasource

import com.survivalcoding.ifkakao.data.api.IfKakaoService
import com.survivalcoding.ifkakao.data.dto.convert
import com.survivalcoding.ifkakao.domain.entity.Session
import javax.inject.Inject

class IfKakaoRetrofitDataSource @Inject constructor(private val ifKakaoService: IfKakaoService) :
    IfKakaoRemoteDataSource {

    private var sessions: List<Session>? = null

    override suspend fun getAllSessions(): List<Session> {
        return if (sessions.isNullOrEmpty()) {
            val ifKakaoResponse = ifKakaoService.getAllSessions()
            sessions = if (ifKakaoResponse.isSuccessful) {
                ifKakaoResponse.body()?.data?.convert()
            } else {
                null
            }

            sessions
        } else {
            sessions
        } ?: listOf()
    }
}