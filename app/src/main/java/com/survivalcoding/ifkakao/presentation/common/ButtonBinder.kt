package com.survivalcoding.ifkakao.presentation.common

class ButtonBinder(private val text: String, private val onClick: () -> Unit) : CommonBinder {

    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        TODO("Not yet implemented")
    }

    companion object {
        const val ID = 1 // TODO
    }
}