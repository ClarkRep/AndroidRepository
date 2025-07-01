package com.clark.baseui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TestCustormView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.strokeWidth = 50F //  设置画笔宽度

        paint.color = Color.RED // 设置画笔颜色
        paint.style = Paint.Style.FILL    // 设置填充样式
        canvas.drawCircle(200F, 200F, 100F, paint) // 绘制圆形，圆心坐标(200, 200)，半径100

        paint.color = Color.YELLOW // 设置画笔颜色
        paint.style = Paint.Style.STROKE    // 设置填充样式
        canvas.drawCircle(200F, 500F, 100F, paint) // 绘制圆形，圆心坐标(200, 500)，半径100

        paint.color = Color.BLUE // 设置画笔颜色
        paint.style = Paint.Style.FILL_AND_STROKE    // 设置填充样式
        canvas.drawCircle(200F, 800F, 100F, paint) // 绘制圆形，圆心坐标(200, 800)，半径100
    }

}