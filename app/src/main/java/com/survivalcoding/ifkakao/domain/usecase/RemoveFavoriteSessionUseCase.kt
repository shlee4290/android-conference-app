package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import javax.inject.Inject

class RemoveFavoriteSessionUseCase @Inject constructor(private val ifKakaoRepository: IfKakaoRepository) {
    suspend operator fun invoke(sessionId: Int) = ifKakaoRepository.removeFavoriteSession(sessionId)
}