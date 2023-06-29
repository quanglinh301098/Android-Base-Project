package com.example.androidbaseproject_2.ui

import androidx.activity.viewModels
import com.example.androidbaseproject_2.R
import com.example.androidbaseproject_2.base.BaseActivity
import com.example.androidbaseproject_2.databinding.ActivityMainBinding
import com.example.androidbaseproject_2.utils.ext.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val viewModel by viewModels<MainActivityViewModel>()
    override fun initView() {

    }

    override fun observer() {
        viewModel.apply {
            currentUserId.observe(this@MainActivity) {
                showToast(it)
            }
        }
    }

    override fun initEvent() {
        binding.btnOk.setOnClickListener {
            viewModel.setCurrentUser(binding.edt.text.toString())
        }
    }

}