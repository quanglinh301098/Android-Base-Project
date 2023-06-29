package com.linhpham.goodnight.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.linhpham.goodnight.R
import com.linhpham.goodnight.databinding.ViewCustomToolbarBinding

class CustomToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val binding = ViewCustomToolbarBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomToolbar,
            0, 0
        ).apply {
            try {
                binding.tvTitle.text = getString(R.styleable.CustomToolbar_title) ?: ""
                binding.tvSubTitle.text = getString(R.styleable.CustomToolbar_subTitle) ?: ""
            } finally {
                recycle()
            }
        }
    }
}
