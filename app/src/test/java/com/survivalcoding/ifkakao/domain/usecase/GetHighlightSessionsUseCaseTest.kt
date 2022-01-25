package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import com.survivalcoding.ifkakao.testUtil.MockUtil
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetHighlightSessionsUseCaseTest {

    private lateinit var getHighlightSessionsUseCase: GetHighlightSessionsUseCase
    private lateinit var fakeIfKakaoRepository: IfKakaoRepository

    @Before
    fun setUp() {
        fakeIfKakaoRepository = Mockito.mock(IfKakaoRepository::class.java)
        runBlocking {
            Mockito.`when`(fakeIfKakaoRepository.getAllSessions()).thenReturn(MockUtil.mockSessions())
        }

        getHighlightSessionsUseCase = GetHighlightSessionsUseCase(fakeIfKakaoRepository)
    }

    @Test
    fun `하이라이트 세션들을 잘 가져오는지 테스트`() {
        runBlocking {
            assertEquals(2, getHighlightSessionsUseCase().size)
            getHighlightSessionsUseCase().forEach {
                assertEquals(true, it.isHighlight)
            }
        }
    }

    @After
    fun tearDown() {
    }

}