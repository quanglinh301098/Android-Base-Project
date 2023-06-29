package com.linhpham.goodnight.ui.dashboard.settings

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.linhpham.goodnight.base.BaseFragment
import com.linhpham.goodnight.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    val viewModel by viewModels<SettingsViewModel>()
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)

    override fun initViews() {
        Log.d("test", "initView")
    }

    override fun initActions() {
    }

    override fun startObservingValues() {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("test", "destrouview")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test", "destroy")
    }
}