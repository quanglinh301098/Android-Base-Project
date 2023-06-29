package com.linhpham.goodnight.ui.dashboard.detail

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.linhpham.goodnight.base.BaseFragmentVM
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : BaseFragmentVM() {

    fun tessst() {
        viewModelScope.launch(Dispatchers.Unconfined) {
            delay(3000)
            Log.d("test", "vẫn còn chạy, chưa ngừng")
        }

    }

}