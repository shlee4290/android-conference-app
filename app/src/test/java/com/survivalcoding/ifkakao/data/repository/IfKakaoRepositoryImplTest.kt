package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.datasource.IfKakaoLocalDataSource
import com.survivalcoding.ifkakao.data.datasource.IfKakaoRemoteDataSource
import com.survivalcoding.ifkakao.testUtil.MockIfKakaoSessionsBuilder
import kotlinx.coroutines.runBlocking

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

class IfKakaoRepositoryImplTest {

    @InjectMocks
    private lateinit var ifKakaoRepositoryImpl: IfKakaoRepositoryImpl

    @Mock
    private lateinit var mockIfKakaoLocalDataSource: IfKakaoLocalDataSource

    @Mock
    private lateinit var mockIfKakaoRemoteDataSource: IfKakaoRemoteDataSource

    private val mockSessions = MockIfKakaoSessionsBuilder().addSession(isFavorite = false)
        .addSession(isFavorite = false)
        .addSession(isFavorite = false)
        .addSession(isFavorite = false)
        .addSession(isFavorite = false)
        .addSession(isFavorite = false)
        .addSession(isFavorite = false)
        .build()

    @Before
    fun setUp() {
        mockIfKakaoLocalDataSource = Mockito.mock(IfKakaoLocalDataSource::class.java)
        mockIfKakaoRemoteDataSource = Mockito.mock(IfKakaoRemoteDataSource::class.java)

        runBlocking {
            Mockito.`when`(mockIfKakaoLocalDataSource.getAllFavorite()).thenReturn(
                listOf(1, 3, 5)
            )
            Mockito.`when`(mockIfKakaoRemoteDataSource.getAllSessions()).thenReturn(
                mockSessions
            )
        }

        ifKakaoRepositoryImpl = IfKakaoRepositoryImpl(mockIfKakaoRemoteDataSource, mockIfKakaoLocalDataSource)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `좋아요 한 세션을 잘 가져오는지 확인`() {
        runBlocking {
            Assert.assertEquals(
                mockSessions.filter { it.idx == 1 || it.idx == 3 || it.idx == 5 }.map { it.copy(isFavorite = true) },
                ifKakaoRepositoryImpl.getAllSessions().filter { it.isFavorite }
            )
        }
    }
}