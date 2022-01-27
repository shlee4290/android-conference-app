package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import javax.inject.Inject

class AddFavoriteSessionUseCase @Inject constructor(private val ifKakaoRepository: IfKakaoRepository) {
    suspend operator fun invoke(sessionId: Int) = ifKakaoRepository.addFavoriteSession(sessionId)
}