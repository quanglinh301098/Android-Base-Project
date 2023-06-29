package com.linhpham.goodnight.ui.dashboard.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.linhpham.goodnight.base.BaseFragment
import com.linhpham.goodnight.databinding.FragmentNavHomeBinding

class NavHomeFragment : BaseFragment<FragmentNavHomeBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNavHomeBinding  = FragmentNavHomeBinding.inflate(inflater, container, false)

    override fun initViews() {
    }

    override fun initActions() {
    }

    override fun startObservingValues() {
    }
}