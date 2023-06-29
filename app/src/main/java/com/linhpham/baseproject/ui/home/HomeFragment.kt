package com.linhpham.baseproject.ui.home

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.linhpham.baseproject.base.BaseFragment
import com.linhpham.baseproject.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initViews() {

    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun initActions() {

    }

    override fun startObservingValues() {

    }


}