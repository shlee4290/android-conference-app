package com.survivalcoding.ifkakao.presentation.common

interface CommonBinder {
    val id: Int

    fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean
}