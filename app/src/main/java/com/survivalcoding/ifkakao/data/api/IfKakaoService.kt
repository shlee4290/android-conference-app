package com.survivalcoding.ifkakao.data.api

import com.survivalcoding.ifkakao.data.dto.IfKakaoResponse
import retrofit2.Response
import retrofit2.http.GET

interface IfKakaoService {
    @GET("/junsuk5/mock_json/main/conf21/contents.json")
    suspend fun getAllSessions(): Response<IfKakaoResponse>
}