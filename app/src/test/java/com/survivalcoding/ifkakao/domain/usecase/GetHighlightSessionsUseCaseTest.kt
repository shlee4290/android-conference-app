package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import com.survivalcoding.ifkakao.testUtil.MockIfKakaoSessionsBuilder
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.internal.util.MockUtil

class GetHighlightSessionsUseCaseTest {

    private lateinit var getHighlightSessionsUseCase: GetHighlightSessionsUseCase
    private lateinit var fakeIfKakaoRepository: IfKakaoRepository
    private val mockSessions = MockIfKakaoSessionsBuilder().addSession(isHighlight = true)
        .addSession(isHighlight = true)
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

        getHighlightSessionsUseCase = GetHighlightSessionsUseCase(fakeIfKakaoRepository)
    }

    @Test
    fun `하이라이트 세션들을 잘 가져오는지 테스트`() {
        runBlocking {
            val mockHighlightSessions = mockSessions.filter { it.isHighlight }
            val result = getHighlightSessionsUseCase()

            assertTrue(
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