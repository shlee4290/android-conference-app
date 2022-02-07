package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.entity.Categories
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.entity.SortBy
import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import javax.inject.Inject

class GetSelectedSessionsUseCase @Inject constructor(private val ifKakaoRepository: IfKakaoRepository) {
    suspend operator fun invoke(
        day: Int = 3,
        categories: Categories = Categories(),
        sortBy: SortBy = SortBy.DEFAULT
    ): List<Session> {
        return ifKakaoRepository.getAllSessions().filter { session ->
            if (day == 3) true // Day3(All)
            else session.exposureDay == day
        }.filter { session ->
            categories.business.forEach {
                if (it !in session.categories.business) {
                    return@filter false
                }
            }

            categories.company.forEach {
                if (it !in session.categories.company) {
                    return@filter false
                }
            }

            categories.field.forEach {
                if (it !in session.categories.field) {
                    return@filter false
                }
            }

            categories.tech.forEach {
                if (it !in session.categories.tech) {
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