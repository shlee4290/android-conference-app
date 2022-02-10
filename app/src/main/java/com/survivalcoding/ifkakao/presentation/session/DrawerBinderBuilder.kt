package com.survivalcoding.ifkakao.presentation.session

import android.text.Editable
import android.widget.RadioGroup
import com.survivalcoding.ifkakao.presentation.common.*

class DrawerBinderBuilder {
    private val drawerBinderList = mutableListOf<CommonBinder>()

    fun addTitle(text: String): DrawerBinderBuilder {
        drawerBinderList.add(DrawerTitleBinder(text))

        return this
    }

    fun addSubtitle(text: String): DrawerBinderBuilder {
        drawerBinderList.add(DrawerSubtitleBinder(text))

        return this
    }

    fun addEditText(initText: String, afterTextChanged: (Editable) -> Unit): DrawerBinderBuilder {
        drawerBinderList.add(DrawerEditTextBinder(initText, afterTextChanged))

        return this
    }

    fun addSortRadioGroup(
        onCheckedChanged: (RadioGroup, Int) -> Unit,
        checkedId: Int
    ): DrawerBinderBuilder {
        drawerBinderList.add(
            DrawerSortRadioGroupBinder(
                onCheckedChanged,
                checkedId
            )
        )

        return this
    }

    fun addKeywordToggleList(keywordToggleListBinder: KeywordToggleListBinder): DrawerBinderBuilder {
        drawerBinderList.add(keywordToggleListBinder)

        return this
    }

    fun build(): List<CommonBinder> {
        return drawerBinderList
    }
}