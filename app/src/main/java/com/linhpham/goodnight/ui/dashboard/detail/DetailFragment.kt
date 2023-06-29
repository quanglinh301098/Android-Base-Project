package com.linhpham.goodnight.ui.dashboard.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.linhpham.goodnight.base.BaseFragment
import com.linhpham.goodnight.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentHomeBinding>() {

    val viewModel by viewModels<DetailViewModel> ()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initViews() {
        viewModel.tessst()
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