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
        assertEquals(2, getSelectedSessionsUseCase(day = 3).size)
        assertEquals(0, getSelectedSessionsUseCase(day = 0).size)
        assertEquals(0, getSelectedSessionsUseCase(day = 4).size)

        getSelectedSessionsUseCase(day = 1).forEach {
            assertEquals(1, it.exposureDay)
        }

        getSelectedSessionsUseCase(day = 2).forEach {
            assertEquals(2, it.exposureDay)
        }

        getSelectedSessionsUseCase(day = 3).forEach {
            assertEquals(3, it.exposureDay)
        }
    }

    @Test
    fun `기준에 맞춰 세션들을 가져오는지 테스트`() {

    }
}