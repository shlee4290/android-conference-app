package com.survivalcoding.ifkakao.data.dto

data class IfKakaoResponse(
    val success: Boolean?,
    val code: Int?,
    val data: List<Session>?,
    val count: Int?,
    val errorMessage: String?
)
