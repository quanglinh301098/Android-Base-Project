package com.linhpham.baseproject.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import com.linhpham.baseproject.base.BaseFragment
import com.linhpham.baseproject.databinding.FragmentNavSettingsBinding

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