package com.survivalcoding.ifkakao.domain.usecase

import com.survivalcoding.ifkakao.domain.entity.Categories
import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.entity.SortBy
import com.survivalcoding.ifkakao.domain.repository.IfKakaoRepository
import com.survivalcoding.ifkakao.testUtil.MockIfKakaoSessionsBuilder
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetSelectedSessionsUseCaseTest {

    private lateinit var getSelectedSessionsUseCase: GetSelectedSessionsUseCase
    private lateinit var fakeIfKakaoRepository: IfKakaoRepository

    @Before
    fun setUp() {
        fakeIfKakaoRepository = Mockito.mock(IfKakaoRepository::class.java)
        getSelectedSessionsUseCase = GetSelectedSessionsUseCase(fakeIfKakaoRepository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `1일차의 세션들을 잘 가져오는지 테스트`() {
        runBlocking {
            val twoSessionsPerDay = MockIfKakaoSessionsBuilder().addSession(exposureDay = 1)
                .addSession(exposureDay = 1)
                .addSession(exposureDay = 2)
                .addSession(exposureDay = 2)
                .addSession(exposureDay = 3)
                .addSession(exposureDay = 3)
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(twoSessionsPerDay)

            val day1Session = twoSessionsPerDay.filter { it.exposureDay == 1 }
            val result = getSelectedSessionsUseCase(day = 1)

            assertTrue(result.containsAll(day1Session) && day1Session.containsAll(result))
        }
    }

    @Test
    fun `2일차의 세션들을 잘 가져오는지 테스트`() {
        runBlocking {
            val twoSessionsPerDay = MockIfKakaoSessionsBuilder().addSession(exposureDay = 1)
                .addSession(exposureDay = 1)
                .addSession(exposureDay = 2)
                .addSession(exposureDay = 2)
                .addSession(exposureDay = 3)
                .addSession(exposureDay = 3)
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(twoSessionsPerDay)

            val day2Session = twoSessionsPerDay.filter { it.exposureDay == 2 }
            val result = getSelectedSessionsUseCase(day = 2)

            assertTrue(result.containsAll(day2Session) && day2Session.containsAll(result))
        }
    }

    @Test
    fun `3일차에는 모든 세션을 가져오는지 테스트`() {
        runBlocking {
            val twoSessionsPerDay = MockIfKakaoSessionsBuilder().addSession(exposureDay = 1)
                .addSession(exposureDay = 1)
                .addSession(exposureDay = 2)
                .addSession(exposureDay = 2)
                .addSession(exposureDay = 3)
                .addSession(exposureDay = 3)
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(twoSessionsPerDay)

            val result = getSelectedSessionsUseCase(day = 3)

            assertTrue(result.containsAll(twoSessionsPerDay) && twoSessionsPerDay.containsAll(result))
        }
    }

    @Test
    fun `세션 없는 날엔 빈 리스트 가져오는지 테스트`() {
        runBlocking {
            val twoSessionsPerDay = MockIfKakaoSessionsBuilder().addSession(exposureDay = 1)
                .addSession(exposureDay = 1)
                .addSession(exposureDay = 2)
                .addSession(exposureDay = 2)
                .addSession(exposureDay = 3)
                .addSession(exposureDay = 3)
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(twoSessionsPerDay)

            assertEquals(listOf<Session>(), getSelectedSessionsUseCase(day = 4))
            assertEquals(listOf<Session>(), getSelectedSessionsUseCase(day = 0))
        }
    }

    @Test
    fun `선택된 비즈니스 카테고리의 세션을 잘 가져오는지 테스트`() {
        runBlocking {
            val mockSessions = MockIfKakaoSessionsBuilder().addSession(exposureDay = 1)
                .addSession(
                    categories = Categories(
                        field = listOf(Category.Field("서비스")),
                        business = listOf(Category.Business("플랫폼")),
                        tech = listOf(Category.Tech("데이터")),
                        company = listOf(Category.Company("카카오"))
                    )
                )
                .addSession()
                .addSession()
                .addSession()
                .addSession()
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(mockSessions)

            assertEquals(
                mockSessions.filter { it.categories.business.contains(Category.Business("플랫폼")) },
                getSelectedSessionsUseCase(
                    categories = Categories(
                        business = listOf(
                            Category.Business(
                                "플랫폼"
                            )
                        )
                    )
                )
            )
        }
    }

    @Test
    fun `선택된 필드 카테고리의 세션을 잘 가져오는지 테스트`() {
        runBlocking {
            val mockSessions = MockIfKakaoSessionsBuilder().addSession(exposureDay = 1)
                .addSession(
                    categories = Categories(
                        field = listOf(Category.Field("서비스")),
                        business = listOf(Category.Business("플랫폼")),
                        tech = listOf(Category.Tech("데이터")),
                        company = listOf(Category.Company("카카오"))
                    )
                )
                .addSession()
                .addSession()
                .addSession()
                .addSession()
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(mockSessions)

            assertEquals(
                mockSessions.filter { it.categories.field.contains(Category.Field("서비스")) },
                getSelectedSessionsUseCase(categories = Categories(field = listOf(Category.Field("서비스"))))
            )
        }
    }

    @Test
    fun `선택된 테크 카테고리의 세션을 잘 가져오는지 테스트`() {
        runBlocking {
            val mockSessions = MockIfKakaoSessionsBuilder().addSession(exposureDay = 1)
                .addSession(
                    categories = Categories(
                        field = listOf(Category.Field("서비스")),
                        business = listOf(Category.Business("플랫폼")),
                        tech = listOf(Category.Tech("데이터")),
                        company = listOf(Category.Company("카카오"))
                    )
                )
                .addSession()
                .addSession()
                .addSession()
                .addSession()
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(mockSessions)

            assertEquals(
                mockSessions.filter { it.categories.tech.contains(Category.Tech("데이터")) },
                getSelectedSessionsUseCase(categories = Categories(tech = listOf(Category.Tech("데이터"))))
            )
        }
    }

    @Test
    fun `선택된 회사 카테고리의 세션을 잘 가져오는지 테스트`() {
        runBlocking {
            val mockSessions = MockIfKakaoSessionsBuilder().addSession(exposureDay = 1)
                .addSession(
                    categories = Categories(
                        field = listOf(Category.Field("서비스")),
                        business = listOf(Category.Business("플랫폼")),
                        tech = listOf(Category.Tech("데이터")),
                        company = listOf(Category.Company("카카오"))
                    )
                )
                .addSession()
                .addSession()
                .addSession()
                .addSession()
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(mockSessions)

            assertEquals(
                mockSessions.filter { it.categories.company.contains(Category.Company("카카오")) },
                getSelectedSessionsUseCase(categories = Categories(company = listOf(Category.Company("카카오"))))
            )
        }
    }

    @Test
    fun `매칭되는 카테고리가 없으면 빈 리스트를 가져오는지 테스트`() {
        runBlocking {
            val mockSessions = MockIfKakaoSessionsBuilder().addSession(exposureDay = 1)
                .addSession(
                    categories = Categories(
                        field = listOf(Category.Field("서비스")),
                        business = listOf(Category.Business("플랫폼")),
                        tech = listOf(Category.Tech("데이터")),
                        company = listOf(Category.Company("카카오"))
                    )
                )
                .addSession()
                .addSession()
                .addSession()
                .addSession()
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(mockSessions)

            assertEquals(
                listOf<Session>(),
                getSelectedSessionsUseCase(
                    categories = Categories(
                        field = listOf(Category.Field("없음")),
                        business = listOf(Category.Business("플랫폼")),
                        tech = listOf(Category.Tech("데이터")),
                        company = listOf(Category.Company("카카오"))
                    )
                )
            )
        }
    }

    @Test
    fun `선택된 여러 카테고리의 세션들을 잘 가져오는지 테스트`() {
        runBlocking {
            val mockSessions = MockIfKakaoSessionsBuilder().addSession(exposureDay = 1)
                .addSession(
                    categories = Categories(
                        field = listOf(Category.Field("서비스")),
                        business = listOf(Category.Business("플랫폼")),
                        tech = listOf(Category.Tech("데이터")),
                        company = listOf(Category.Company("카카오"))
                    )
                )
                .addSession()
                .addSession()
                .addSession()
                .addSession()
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(mockSessions)

            assertEquals(
                mockSessions.filter { Category.Field("서비스") in it.categories.field && Category.Business("플랫폼") in it.categories.business && Category.Tech("데이터") in it.categories.tech && Category.Company("카카오") in it.categories.company },
                getSelectedSessionsUseCase(
                    categories = Categories(
                        field = listOf(Category.Field("서비스")),
                        business = listOf(Category.Business("플랫폼")),
                        tech = listOf(Category.Tech("데이터")),
                        company = listOf(Category.Company("카카오"))
                    )
                )
            )
        }
    }

    @Test
    fun `기본 정렬 상태에서 session의 idx 값으로 정렬되는지 테스트`() {
        runBlocking {
            val mockSessions = MockIfKakaoSessionsBuilder().addSession()
                .addSession()
                .addSession()
                .addSession()
                .addSession()
                .addSession()
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(mockSessions)

            assertEquals(mockSessions.sortedBy { it.idx }, getSelectedSessionsUseCase())
        }
    }

    @Test
    fun `title 기준 정렬 상태에서 제대로 정렬 되는지 테스트`() {
        runBlocking {
            val mockSessions = MockIfKakaoSessionsBuilder().addSession()
                .addSession()
                .addSession()
                .addSession()
                .addSession()
                .addSession()
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(mockSessions)

            assertEquals(
                mockSessions.sortedBy { it.title },
                getSelectedSessionsUseCase(sortBy = SortBy.TITLE)
            )
        }
    }

    @Test
    fun `기준에 맞춰 세션들을 가져오는지 테스트`() {
        runBlocking {
            val mockSessions = MockIfKakaoSessionsBuilder().addSession(exposureDay = 1, title = "D")
                .addSession(
                    exposureDay = 1,
                    title = "A",
                    categories = Categories(
                        field = listOf(Category.Field("서비스")),
                        business = listOf(Category.Business("플랫폼")),
                        tech = listOf(Category.Tech("데이터")),
                        company = listOf(Category.Company("카카오"))
                    )
                )
                .addSession(
                    exposureDay = 1,
                    title = "B",
                    categories = Categories(
                        field = listOf(Category.Field("서비스")),
                        business = listOf(Category.Business("플랫폼")),
                        company = listOf(Category.Company("카카오"))
                    )
                )
                .addSession(
                    exposureDay = 1,
                    title = "C",
                    categories = Categories(
                        field = listOf(Category.Field("서비스")),
                        business = listOf(Category.Business("플랫폼")),
                        tech = listOf(Category.Tech("데이터")),
                        company = listOf(Category.Company("카카오"))
                    )
                )
                .addSession()
                .addSession()
                .shuffle()
                .build()

            Mockito.`when`(fakeIfKakaoRepository.getAllSessions())
                .thenReturn(mockSessions)

            assertEquals(
                mockSessions.filter { it.exposureDay == 1 && it.categories.field.contains(Category.Field("서비스")) }
                    .sortedBy { it.title },
                getSelectedSessionsUseCase(
                    day = 1,
                    categories = Categories(field = listOf(Category.Field("서비스"))),
                    sortBy = SortBy.TITLE
                )
            )
        }
    }
}