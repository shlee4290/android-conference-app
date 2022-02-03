package com.survivalcoding.ifkakao.presentation.common

import com.survivalcoding.ifkakao.R

class KeywordToggleListBinder(val keywordToggleBinderList: List<KeywordToggleBinder>) :
    CommonBinder {

    override val id = ID

    override fun areContentsTheSame(oldItem: CommonBinder, newItem: CommonBinder): Boolean {
        oldItem as KeywordToggleListBinder
        newItem as KeywordToggleListBinder

        return oldItem.keywordToggleBinderList == newItem.keywordToggleBinderList
    }

    companion object {
        const val ID = R.layout.keyword_toggle_list
    }
}