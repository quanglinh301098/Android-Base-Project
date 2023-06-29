package com.linhpham.baseproject.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.linhpham.baseproject.base.BaseFragment
import com.linhpham.baseproject.data.user.entity.User
import com.linhpham.baseproject.databinding.FragmentLoginBinding
import com.linhpham.baseproject.model.Resource

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private val viewModel by viewModels<LoginViewModel> ()
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding  = FragmentLoginBinding.inflate(inflater,container, false)

    override val handleBackPress: Boolean = false

    override fun initViews() {

    }

    override fun initActions() {
        binding.btnLoginFacebook.setOnClickListener {
            //login facebook -> co ket qua thi call api
            val user = User(userId = "test")
            viewModel.login(user).observe(viewLifecycleOwner){
                when(it.status){
                    Resource.Status.SUCCESS -> {
                        //call api SUCCESS, and next to home

                    }
                    Resource.Status.ERROR -> {} //call api fail
                    Resource.Status.LOADING ->{} //show loading
                }
            }
        }
    }

    override fun startObservingValues() {


    }
}