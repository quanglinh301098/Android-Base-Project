package com.example.androidbaseproject_2.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity <B: ViewBinding>( val bindingFactory: (LayoutInflater) -> B) : AppCompatActivity() {
    val binding: B by lazy { bindingFactory(layoutInflater) }

    abstract fun initView()
    abstract fun initEvent()
    abstract fun observer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        initEvent()
        observer()
    }
}