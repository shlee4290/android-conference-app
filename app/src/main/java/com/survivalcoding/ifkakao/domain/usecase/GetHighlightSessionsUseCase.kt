package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import javax.inject.Inject

class GetHighlightSessionsUseCase @Inject constructor(private val ifKakaoRepository: IfKakaoRepository) {
    suspend operator fun invoke(): List<Session> = ifKakaoRepository.getAllSessions().filter {
        it.isHighlight
    }
}