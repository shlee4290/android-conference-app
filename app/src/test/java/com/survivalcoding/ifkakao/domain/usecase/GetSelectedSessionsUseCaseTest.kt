package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import com.survivalcoding.ifkakao.testUtil.MockUtil
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetSelectedSessionsUseCaseTest {

    private lateinit var getSelectedSessionsUseCase: GetSelectedSessionsUseCase
    private lateinit var fakeIfKakaoRepository: IfKakaoRepository

    @Before
    fun setUp() {
        fakeIfKakaoRepository = Mockito.mock(IfKakaoRepository::class.java)
        Mockito.`when`(fakeIfKakaoRepository.getAllSessions()).thenReturn(MockUtil.mockSessions())

        getSelectedSessionsUseCase = GetSelectedSessionsUseCase(fakeIfKakaoRepository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `선택된 날짜의 세션들을 잘 가져오는지 테스트`() {
        assertEquals(2, getSelectedSessionsUseCase(day = 1).size)
        assertEquals(2, getSelectedSessionsUseCase(day = 2).size)
        assertEquals(6, getSelectedSessionsUseCase(day = 3).size)
        assertEquals(0, getSelectedSessionsUseCase(day = 0).size)
        assertEquals(0, getSelectedSessionsUseCase(day = 4).size)

        getSelectedSessionsUseCase(day = 1).forEach {
            assertEquals(1, it.exposureDay)
        }

        getSelectedSessionsUseCase(day = 2).forEach {
            assertEquals(2, it.exposureDay)
        }
    }

    @Test
    fun `선택된 카테고리의 세션들을 잘 가져오는지 테스트`() {
        val fieldCategory = Category(field = listOf("서비스"))
        assertEquals(2, getSelectedSessionsUseCase(category = fieldCategory).size)

        val businessCategory = Category(business = listOf("플랫폼"))
        assertEquals(2, getSelectedSessionsUseCase(category = businessCategory).size)

        val techCategory = Category(tech = listOf("데이터"))
        assertEquals(2, getSelectedSessionsUseCase(category = techCategory).size)

        val companyCategory = Category(company = listOf("카카오"))
        assertEquals(2, getSelectedSessionsUseCase(category = companyCategory).size)

        val complicateCategory = Category(
            field = listOf("서비스"),
            business = listOf("플랫폼"),
            tech = listOf("데이터"),
            company = listOf("카카오")
        )
        val resultList = getSelectedSessionsUseCase(category = complicateCategory)
        assertEquals(1, resultList.size)
        assertEquals(
            MockUtil.mockSessions().filter { "서비스" in it.category.field && "플랫폼" in it.category.business && "데이터" in it.category.tech && "카카오" in it.category.company },
            resultList
        )

        val noMatchingCategory = Category(
            field = listOf("없음"),
            business = listOf("플랫폼"),
            tech = listOf("데이터"),
            company = listOf("카카오")
        )
        assertEquals(0, getSelectedSessionsUseCase(category = noMatchingCategory).size)
    }

    @Test
    fun `기준에 맞춰 세션들을 가져오는지 테스트`() {
        val category1 = Category(field = listOf("서비스"))
        assertEquals(2, getSelectedSessionsUseCase(day = 1, category = category1).size)

        val category2 = Category(business = listOf("플랫폼"))
        assertEquals(
            MockUtil.mockSessions().filter { it.exposureDay == 2 && "플랫폼" in it.category.business },
            getSelectedSessionsUseCase(day = 2, category = category2)
        )
    }
}