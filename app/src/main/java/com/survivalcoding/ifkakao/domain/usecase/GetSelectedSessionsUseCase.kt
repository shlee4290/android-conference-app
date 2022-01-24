package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository

class GetSelectedSessionsUseCase constructor(private val ifKakaoRepository: IfKakaoRepository) {
    operator fun invoke(day: Int = 3, category: Category = Category()): List<Session> {
        return ifKakaoRepository.getAllSessions().filter { session ->
            if (day == 3) true // Day3(All)
            else session.exposureDay == day
        }.filter { session ->
            category.business.forEach {
                if (it !in session.category.business) {
                    return@filter false
                }
            }

            category.company.forEach {
                if (it !in session.category.company) {
                    return@filter false
                }
            }

            category.field.forEach {
                if (it !in session.category.field) {
                    return@filter false
                }
            }

            category.tech.forEach {
                if (it !in session.category.tech) {
                    return@filter false
                }
            }

            true
        }
    }
}