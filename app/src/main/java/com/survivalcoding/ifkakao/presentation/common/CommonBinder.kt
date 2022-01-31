package com.survivalcoding.ifkakao.presentation.common

sealed interface CommonBinder {
    val id: Int

    fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean
}