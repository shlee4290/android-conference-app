package com.survivalcoding.ifkakao.core.di

import com.survivalcoding.ifkakao.BuildConfig
import com.survivalcoding.ifkakao.data.api.IfKakaoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class IfKakaoProviderModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        // log
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            builder.addInterceptor(loggingInterceptor)
        }

        // timeout
        builder.readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
        builder.writeTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
        builder.connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideIfKakaoService(okHttpClient: OkHttpClient): IfKakaoService {
        return Retrofit.Builder().baseUrl(IF_KAKAO_BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).client(okHttpClient)
            .build()
            .create(IfKakaoService::class.java)
    }

    companion object {
        private const val IF_KAKAO_BASE_URL = "https://raw.githubusercontent.com/"
        private const val TIME_OUT_SECONDS = 2L
    }
}