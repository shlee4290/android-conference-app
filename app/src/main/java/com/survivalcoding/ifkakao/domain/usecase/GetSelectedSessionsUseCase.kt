package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository

class GetSelectedSessionsUseCase constructor(private val ifKakaoRepository: IfKakaoRepository) {
    operator fun invoke(day: Int): List<Session> {
        return ifKakaoRepository.getAllSessions().filter {
            it.exposureDay == day
        }
    }
}