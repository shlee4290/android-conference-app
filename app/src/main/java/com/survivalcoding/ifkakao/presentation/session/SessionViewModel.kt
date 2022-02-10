package com.survivalcoding.ifkakao.presentation.session

import android.app.Application
import android.text.Editable
import android.widget.RadioGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.domain.entity.*
import com.survivalcoding.ifkakao.domain.usecase.GetAllCategoriesUseCase
import com.survivalcoding.ifkakao.domain.usecase.GetSelectedSessionsUseCase
import com.survivalcoding.ifkakao.presentation.common.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(
    private val application: Application,
    private val getSelectedSessionsUseCase: GetSelectedSessionsUseCase,
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
) :
    ViewModel() {

    private val initStateBinder = CommonListBinder(listOf(LoadingIndicatorBinder(), FooterBinder()))

    private val _uiState =
        MutableStateFlow(
            UiState(
                initStateBinder,
                initStateBinder,
                initStateBinder,
                listOf(),
                0
            )
        )
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val selectedCategories = mutableSetOf<Category>()
    private var sortBy: SortBy = DEFAULT_SORT_BY

    private var searchKeyword = ""

    init {
        viewModelScope.launch {
            resetSelectedCategories()
        }
    }

    private suspend fun buildDrawerBinderList(): List<CommonBinder> {
        val drawerBinderList = mutableListOf<CommonBinder>()
        val allCategories = getAllCategoriesUseCase()
        drawerBinderList.add(DrawerTitleBinder(application.getString(R.string.search)))
        drawerBinderList.add(DrawerEditTextBinder(searchKeyword, ::afterSearchKeywordChanged))
        drawerBinderList.add(DrawerTitleBinder(application.getString(R.string.sort)))
        drawerBinderList.add(
            DrawerSortRadioGroupBinder(
                ::onSortRadioGroupCheckChange,
                ID_OF_DEFAULT_SORT_BY
            )
        )
        drawerBinderList.add(DrawerTitleBinder(application.getString(R.string.interest_field)))
        drawerBinderList.add(KeywordToggleListBinder(allCategories.field.map {
            KeywordToggleBinder(
                category = it,
                selectedCategories = selectedCategories,
                onCheckedChange = ::onKeywordToggleCheckChange
            )
        }))
        drawerBinderList.add(DrawerTitleBinder(application.getString(R.string.interest_keyword)))
        drawerBinderList.add(DrawerSubtitleBinder(application.getString(R.string.service_and_business)))
        drawerBinderList.add(KeywordToggleListBinder(allCategories.business.map {
            KeywordToggleBinder(
                category = it,
                selectedCategories = selectedCategories,
                onCheckedChange = ::onKeywordToggleCheckChange
            )
        }))
        drawerBinderList.add(DrawerSubtitleBinder(application.getString(R.string.tech)))
        drawerBinderList.add(KeywordToggleListBinder(allCategories.tech.map {
            KeywordToggleBinder(
                category = it,
                selectedCategories = selectedCategories,
                onCheckedChange = ::onKeywordToggleCheckChange
            )
        }))
        drawerBinderList.add(DrawerSubtitleBinder(application.getString(R.string.company)))
        drawerBinderList.add(KeywordToggleListBinder(allCategories.company.map {
            KeywordToggleBinder(
                category = it,
                selectedCategories = selectedCategories,
                onCheckedChange = ::onKeywordToggleCheckChange
            )
        }))

        return drawerBinderList
    }

    private fun afterSearchKeywordChanged(text: Editable) {
        searchKeyword = text.toString()
    }

    private fun onSortRadioGroupCheckChange(group: RadioGroup, checkedId: Int) {
        sortBy = when (checkedId) {
            R.id.sort_by_title_radio_button -> SortBy.TITLE
            R.id.sort_by_upload_time_radio_button -> SortBy.UPLOAD_TIME
            R.id.sort_by_play_time_radio_button -> SortBy.PLAY_TIME
            else -> DEFAULT_SORT_BY
        }
    }

    private fun onKeywordToggleCheckChange(isChecked: Boolean, category: Category) {
        if (isChecked) {
            selectedCategories.add(category)
        } else {
            selectedCategories.remove(category)
        }
        println(selectedCategories)
    }

    fun setCategoryFilter() {
        val categoriesBuilder = CategoriesBuilder()
        selectedCategories.map { categoriesBuilder.add(it) }
        val categories = categoriesBuilder.build()

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                day1Sessions = CommonListBinder(
                    getSessionListByDate(1).toBinderList().plus(FooterBinder())
                ),
                day2Sessions = CommonListBinder(
                    getSessionListByDate(2).toBinderList().plus(FooterBinder())
                ),
                day3Sessions = CommonListBinder(
                    getSessionListByDate(3).toBinderList()
                        .apply {
                            if (isEmpty()) sendEvent(Event.NoMatchingSessions)
                        }.plus(FooterBinder())
                ),
                selectedCategoryCount = categories.toList().size + if (searchKeyword.isNotBlank()) 1 else 0
            )
        }
    }

    private suspend fun getSessionListByDate(day: Int): List<Session> {
        val categoriesBuilder = CategoriesBuilder()
        selectedCategories.map { categoriesBuilder.add(it) }
        val categories = categoriesBuilder.build()

        return getSelectedSessionsUseCase(
            day,
            categories = categories,
            sortBy = sortBy,
            searchKeyword = searchKeyword
        )
    }

    private fun List<Session>.toBinderList(): List<SessionListItemBinder> {
        return this.map { SessionListItemBinder(it, ::navigateToSessionDetail) }
    }

    private fun navigateToSessionDetail(session: Session) {
        sendEvent(Event.NavigateToSessionDetail(session.idx))
    }

    fun resetSelectedCategories() {
        selectedCategories.clear()
        sortBy = DEFAULT_SORT_BY
        searchKeyword = ""
        viewModelScope.launch {
            resetDrawerBinderList()
            setCategoryFilter()
        }
    }

    private suspend fun resetDrawerBinderList() {
        _uiState.value = _uiState.value.copy(
            drawerBinderList = buildDrawerBinderList()
        )
    }

    private fun sendEvent(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

    data class UiState(
        val day1Sessions: CommonListBinder,
        val day2Sessions: CommonListBinder,
        val day3Sessions: CommonListBinder,
        val drawerBinderList: List<CommonBinder>,
        val selectedCategoryCount: Int
    )

    sealed class Event {
        object NoMatchingSessions : Event()
        class NavigateToSessionDetail(val id: Int) : Event()
    }

    companion object {
        private val DEFAULT_SORT_BY = SortBy.UPLOAD_TIME
        private const val ID_OF_DEFAULT_SORT_BY = R.id.sort_by_upload_time_radio_button
    }
}