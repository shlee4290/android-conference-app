package com.survivalcoding.ifkakao.presentation.session

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.domain.entity.Category
import com.survivalcoding.ifkakao.domain.entity.Session
import com.survivalcoding.ifkakao.domain.usecase.GetAllCategoriesUseCase
import com.survivalcoding.ifkakao.domain.usecase.GetSelectedSessionsUseCase
import com.survivalcoding.ifkakao.presentation.common.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(
    private val getSelectedSessionsUseCase: GetSelectedSessionsUseCase,
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
) :
    ViewModel() {

    private val _sessionUiState =
        MutableStateFlow(SessionUiState(listOf(), listOf(), listOf(), listOf()))
    val sessionUiState = _sessionUiState.asStateFlow()

    private val selectedCategories = mutableSetOf<Category>()
    init {
        viewModelScope.launch {
            _sessionUiState.value = SessionUiState(
                getSelectedSessionsUseCase(1),
                getSelectedSessionsUseCase(2),
                getSelectedSessionsUseCase(3),
                buildDrawerBinderList()
            )
        }
    }

    private suspend fun buildDrawerBinderList(): List<CommonBinder> {
        val drawerBinderList = mutableListOf<CommonBinder>()
        val allCategories = getAllCategoriesUseCase()
        drawerBinderList.add(DrawerTitleBinder("관심분야"))
        drawerBinderList.add(KeywordToggleListBinder(allCategories.field.map {
            KeywordToggleBinder(
                category = it,
                selectedCategories = selectedCategories,
                onCheckedChange = ::onKeywordToggleCheckChange
            )
        }))
        drawerBinderList.add(DrawerTitleBinder("관심키워드"))
        drawerBinderList.add(DrawerSubtitleBinder("서비스·비즈니스"))
        drawerBinderList.add(KeywordToggleListBinder(allCategories.business.map {
            KeywordToggleBinder(
                category = it,
                selectedCategories = selectedCategories,
                onCheckedChange = ::onKeywordToggleCheckChange
            )
        }))
        drawerBinderList.add(DrawerSubtitleBinder("기술"))
        drawerBinderList.add(KeywordToggleListBinder(allCategories.tech.map {
            KeywordToggleBinder(
                category = it,
                selectedCategories = selectedCategories,
                onCheckedChange = ::onKeywordToggleCheckChange
            )
        }))
        drawerBinderList.add(DrawerSubtitleBinder("공동체분류"))
        drawerBinderList.add(KeywordToggleListBinder(allCategories.company.map {
            KeywordToggleBinder(
                category = it,
                selectedCategories = selectedCategories,
                onCheckedChange = ::onKeywordToggleCheckChange
            )
        }))

        return drawerBinderList
    }

    private fun onKeywordToggleCheckChange(isChecked: Boolean, category: Category) {
        if (isChecked) {
            selectedCategories.add(category)
        } else {
            selectedCategories.remove(category)
        }
        println(selectedCategories)
    }

    fun resetSelectedCategories() {
        selectedCategories.clear()
        viewModelScope.launch {
            resetDrawerBinderList()
        }
    }

    private suspend fun resetDrawerBinderList() {
        _sessionUiState.value = _sessionUiState.value.copy(
            drawerBinderList = buildDrawerBinderList()
        )
    }
}

data class SessionUiState(
    val day1Sessions: List<Session>,
    val day2Sessions: List<Session>,
    val day3Sessions: List<Session>,
    val drawerBinderList: List<CommonBinder>
)