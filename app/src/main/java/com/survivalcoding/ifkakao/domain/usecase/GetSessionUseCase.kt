package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import javax.inject.Inject

class GetSessionUseCase @Inject constructor(private val ifKakaoRepository: IfKakaoRepository) {
    suspend operator fun invoke(id: Int) = ifKakaoRepository.getSession(id)
}