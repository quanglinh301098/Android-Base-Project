package com.linhpham.goodnight.ui.dashboard.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import com.linhpham.goodnight.base.BaseFragment
import com.linhpham.goodnight.databinding.FragmentNavSettingsBinding

class NavSettingsFragment : BaseFragment<FragmentNavSettingsBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNavSettingsBinding  = FragmentNavSettingsBinding.inflate(inflater, container, false)

    override fun initViews() {
    }

    override fun initActions() {
    }

    override fun startObservingValues() {
    }
}