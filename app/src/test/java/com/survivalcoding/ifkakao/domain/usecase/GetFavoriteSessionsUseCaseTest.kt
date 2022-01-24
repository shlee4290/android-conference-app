package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import com.survivalcoding.ifkakao.testUtil.MockUtil
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetFavoriteSessionsUseCaseTest {

    private lateinit var getFavoriteSessionsUseCase: GetFavoriteSessionsUseCase
    private lateinit var fakeIfKakaoRepository: IfKakaoRepository

    @Before
    fun setUp() {
        fakeIfKakaoRepository = Mockito.mock(IfKakaoRepository::class.java)
        Mockito.`when`(fakeIfKakaoRepository.getAllSessions()).thenReturn(MockUtil.mockSessions())

        getFavoriteSessionsUseCase = GetFavoriteSessionsUseCase(fakeIfKakaoRepository)
    }

    @Test
    fun `좋아요 표시된 세션들을 잘 가져오는지 테스트`() {
        val favoriteSessions = getFavoriteSessionsUseCase()

        favoriteSessions.forEach {
            assertEquals(true, it.isFavorite)
        }

        assertEquals(
            MockUtil.mockSessions().filter {
                it.isFavorite
            },
            favoriteSessions
        )
    }

    @After
    fun tearDown() {
    }
}