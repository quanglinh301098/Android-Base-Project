package com.linhpham.baseproject.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.linhpham.baseproject.R
import com.linhpham.baseproject.databinding.ItemSettingDisplayBinding

class ItemSettingDisplay @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {
    private val binding =
        ItemSettingDisplayBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.ItemSettingDisplay, 0, 0).apply {
            try {
                binding.tvMenuName.text =
                    getString(R.styleable.ItemSettingDisplay_display_title) ?: ""
                binding.tvSetting.text =
                    getString(R.styleable.ItemSettingDisplay_display_setting_text) ?: ""
                getDrawable(R.styleable.ItemSettingDisplay_display_setting_icon)?.let {
                    binding.ivSetting.setImageDrawable(it)
                    binding.ivSetting.visibility = View.VISIBLE
                    binding.tvSetting.visibility = View.GONE
                } ?: run {
                    binding.ivSetting.visibility = View.GONE
                    binding.tvSetting.visibility = View.VISIBLE
                }
                binding.divider.visibility = if (getBoolean(
                        R.styleable.ItemSettingDisplay_display_divider,
                        true
                    )
                ) View.VISIBLE else View.GONE
            } finally {
                recycle()
            }
        }
    }

    @Suppress("unused")
    fun setText(text: String) {
        binding.tvSetting.text = text
    }

    fun setValueIconBitmap(idRes: Int){
        binding.ivSetting.setImageResource(idRes)
    }
}