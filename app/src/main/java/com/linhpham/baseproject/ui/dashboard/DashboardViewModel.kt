package com.linhpham.baseproject.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import com.linhpham.baseproject.R
import com.linhpham.baseproject.base.BaseFragmentVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Linh Pham on 1/2/2023.
 **/
@HiltViewModel
class DashboardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseFragmentVM() {
    private val _selectedTab = savedStateHandle.getLiveData(KEY_SELECTED_TAB, R.id.home)
    val selectedTab: LiveData<Int> = _selectedTab

    init {
    }

    fun setSelectedTab(tabId: Int) {
        if (selectedTab.value != tabId) {
            _selectedTab.value = tabId
        }
    }

    companion object {
        private const val KEY_SELECTED_TAB = "selected_tab"
    }
}
