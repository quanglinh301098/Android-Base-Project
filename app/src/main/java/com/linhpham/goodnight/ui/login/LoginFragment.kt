package com.linhpham.goodnight.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.linhpham.goodnight.base.BaseFragment
import com.linhpham.goodnight.databinding.FragmentLoginBinding
import com.linhpham.goodnight.utils.extensions.showToast

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding  = FragmentLoginBinding.inflate(inflater,container, false)

    override val handleBackPress: Boolean = false

    override fun initViews() {

    }

    override fun initActions() {
        binding.btnLoginFacebook.setOnClickListener {
            onBackPressed()
        }
    }

    override fun startObservingValues() {


    }
}