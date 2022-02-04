package com.survivalcoding.ifkakao.core

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.kakao.sdk.common.KakaoSdk
import com.survivalcoding.ifkakao.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class IfKakaoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        KakaoSdk.init(this, BuildConfig.KAKAO_LINK_NATIVE_APP_KEY)
    }
}