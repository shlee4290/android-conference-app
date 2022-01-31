package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(private val ifKakaoRepository: IfKakaoRepository) {
    suspend operator fun invoke(): Category = ifKakaoRepository.getAllCategories()
}