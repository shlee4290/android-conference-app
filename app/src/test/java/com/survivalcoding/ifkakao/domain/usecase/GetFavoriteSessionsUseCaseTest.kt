package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import com.survivalcoding.ifkakao.testUtil.MockIfKakaoSessionsBuilder
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetFavoriteSessionsUseCaseTest {

    private lateinit var getFavoriteSessionsUseCase: GetFavoriteSessionsUseCase
    private lateinit var fakeIfKakaoRepository: IfKakaoRepository
    private val mockSessions = MockIfKakaoSessionsBuilder().addSession(isFavorite = true)
        .addSession(isFavorite = true)
        .addSession()
        .addSession()
        .addSession()
        .addSession()
        .build()

    @Before
    fun setUp() {
        fakeIfKakaoRepository = Mockito.mock(IfKakaoRepository::class.java)
        runBlocking {
            Mockito.`when`(fakeIfKakaoRepository.getAllSessions()).thenReturn(mockSessions)
        }

        getFavoriteSessionsUseCase = GetFavoriteSessionsUseCase(fakeIfKakaoRepository)
    }

    @Test
    fun `좋아요 표시된 세션들을 잘 가져오는지 테스트`() {
        runBlocking {
            val mockHighlightSessions = mockSessions.filter { it.isFavorite }
            val result = getFavoriteSessionsUseCase()

            Assert.assertTrue(
                mockHighlightSessions.containsAll(result) && result.containsAll(
                    mockHighlightSessions
                )
            )
        }
    }

    @After
    fun tearDown() {
    }
}