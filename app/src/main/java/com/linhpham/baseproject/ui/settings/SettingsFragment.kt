package com.linhpham.baseproject.ui.settings

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.linhpham.baseproject.base.BaseFragment
import com.linhpham.baseproject.databinding.FragmentSettingsBinding
import com.linhpham.baseproject.utils.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    val viewModel by viewModels<SettingsViewModel>()
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)

    override fun initViews() {

    }

    override fun initActions() {
        binding.isdStartScreen.setOnClickListener {
            showToast("đã click start screen")
        }

        binding.isdDarkMode.setOnClickListener {
            showToast("dark mode")
        }

    }

    override fun startObservingValues() {

    }

}