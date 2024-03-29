package com.linhpham.baseproject.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.linhpham.baseproject.R
import com.linhpham.baseproject.databinding.ViewButtonBinding
import com.linhpham.baseproject.utils.extensions.hide

class BaseProjectButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {
    private val binding = ViewButtonBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        cardElevation = 0f
        radius = context.resources.getDimensionPixelSize(R.dimen.button_corner_radius).toFloat()
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.BaseProjectButton,
            0, 0
        ).apply {
            try {
                binding.buttonTitle.text = getString(R.styleable.BaseProjectButton_android_title) ?: ""
                binding.buttonTitle.setTextColor(
                    getColor(
                        R.styleable.BaseProjectButton_android_textColor,
                        ContextCompat.getColor(context, R.color.white)
                    )
                )
                getDrawable(R.styleable.BaseProjectButton_android_icon)?.let {
                    binding.buttonIcon.setImageDrawable(it)
                } ?: binding.buttonIcon.hide()

                setCardBackgroundColor(
                    getColor(
                        R.styleable.BaseProjectButton_backgroundColor,
                        ContextCompat.getColor(context, R.color.colorButton)
                    )
                )
            } finally {
                recycle()
            }
        }
    }

    fun setTitle(title:String){
        binding.buttonTitle.text = title
    }
}
