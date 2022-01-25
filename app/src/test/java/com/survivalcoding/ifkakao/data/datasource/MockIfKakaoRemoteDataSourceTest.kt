package com.survivalcoding.ifkakao.data.datasource

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class MockIfKakaoRemoteDataSourceTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `Mock 세션 데이터 불러오기 테스트`() {
        val ifKakaoMockDataSource = MockIfKakaoRemoteDataSource()
        val sessions = runBlocking {
            ifKakaoMockDataSource.getAllSessions()
        }

        sessions.forEach {
            println(it)
        }

        assertEquals(27, sessions.size)
    }
}