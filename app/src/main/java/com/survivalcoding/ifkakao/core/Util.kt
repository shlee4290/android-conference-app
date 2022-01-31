package com.survivalcoding.ifkakao.core

import android.content.Context
import android.util.TypedValue

fun dp2Px(context: Context, dp: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        context.resources.displayMetrics
    )
}