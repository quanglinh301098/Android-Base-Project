package com.linhpham.baseproject.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.SweepGradient
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

class FineTuneButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {

    private val paintText by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            color = 0xFFFFFFFF.toInt()
            isAntiAlias = true
            textSize = 50f
            isDither = true
            textAlign = Paint.Align.CENTER
        }
    }

    private val colors = intArrayOf(
        0xFFF31FFC1.toInt(),
        0xFFFFF1C60D6.toInt() ,
        0xFFFFFBA5757.toInt()  ,
        )

    private val positions = null //floatArrayOf(0f, 0.3f, 0.6f)

    private val paintProgress by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = 50f
            color = 0xFF31FFC1.toInt()
            strokeCap = Paint.Cap.ROUND
            isAntiAlias = true
            isDither = true
            shader = SweepGradient(0f, 0f,
                colors,
                positions,
               )
        }
    }

    private val paintCircleGray by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = 7f
            color = 0xFFFA7A7A7.toInt()
        }
    }

    private val paintCircleBlack by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.FILL
            color = 0xFFF1F2934.toInt()
        }
    }

    var process: Float = 200f
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = min(width, height) / 2f - 50f
        //draw circle
        canvas?.let {
            it.drawCircle(centerX, centerY, radius, paintCircleGray)
            it.drawCircle(centerX, centerY, radius - 120f, paintCircleBlack)
            it.drawArc(
                (centerX - radius),
                (centerY - radius),
                (centerX + radius),
                (centerY + radius), 270F, process, false, paintProgress
            )

            it.drawText(
                "70%",
                centerX,
                centerY-20f,
                paintText
            )

//            it.drawText(
//                "Fine Tune Hz",
//                centerX,
//                centerY + 120f,
//                paintText
//            )

        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        when (MeasureSpec.EXACTLY) {
            MeasureSpec.getMode(widthMeasureSpec) -> {
                val measuredWidth = MeasureSpec.getSize(widthMeasureSpec)
                setMeasuredDimension(
                    measuredWidth,
                    measuredWidth
                )
            }
            MeasureSpec.getMode(heightMeasureSpec) -> {
                val measuredHeight = MeasureSpec.getSize(heightMeasureSpec)
                setMeasuredDimension(
                    measuredHeight,
                    measuredHeight
                )
            }
            else -> {
                setMeasuredDimension(
                    100,
                    100
                )
            }
        }
    }

}