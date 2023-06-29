package com.example.androidbaseproject_2.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B:ViewBinding>(val bindingFactory: (LayoutInflater) -> B) : Fragment() {
    private var _binding : B? = null
    protected val binding get() = _binding!!
    abstract fun observer()
    abstract fun initView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = bindingFactory(inflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observer()
    }
}