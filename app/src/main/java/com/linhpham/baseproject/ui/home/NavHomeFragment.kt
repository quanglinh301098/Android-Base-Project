package com.linhpham.baseproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.linhpham.baseproject.base.BaseFragment
import com.linhpham.baseproject.databinding.FragmentNavHomeBinding

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