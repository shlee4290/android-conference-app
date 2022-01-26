package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.entity.SortBy
import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import javax.inject.Inject

class GetSelectedSessionsUseCase @Inject constructor(private val ifKakaoRepository: IfKakaoRepository) {
    suspend operator fun invoke(
        day: Int = 3,
        category: Category = Category(),
        sortBy: SortBy = SortBy.DEFAULT
    ): List<Session> {
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
        }.sortedBy {
            when (sortBy) {
                SortBy.DEFAULT -> it.idx.toString()
                SortBy.TITLE -> it.title
            }
        }
    }
}