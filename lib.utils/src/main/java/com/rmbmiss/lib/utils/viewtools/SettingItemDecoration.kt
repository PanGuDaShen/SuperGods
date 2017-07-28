package com.rmbmiss.lib.utils.viewtools

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import com.rmbmiss.lib.utils.errortools.ErrorStringTools
import android.util.TypedValue
import android.view.View


/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/28$ 9:47$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/28$ 9:47$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class SettingItemDecoration(context:Context,manager:Int,var size: Int):RecyclerView.ItemDecoration() {

    /*
     * RecyclerView的布局方向，默认先赋值
     * 为纵向布局
     * RecyclerView 布局可横向，也可纵向
     * 横向和纵向对应的分割想画法不一样
     * */
    private var mOrientation = LinearLayoutManager.VERTICAL

    /**
     * item之间分割线的size，默认为1
     */
    private var mItemSize = 1

    /**
     * 绘制item分割线的画笔，和设置其属性
     * 来绘制个性分割线
     */
    private var mPaint: Paint? = null

    init {
        this.mOrientation = manager
        if (mOrientation != LinearLayoutManager.HORIZONTAL && mOrientation != LinearLayoutManager.VERTICAL){
            ErrorStringTools.showString("com.rmbmiss.lib.utils.viewtools.SettingItemDecoration 传入了错误的值！")
        }
        mItemSize = TypedValue.applyDimension(size, TypedValue.COMPLEX_UNIT_DIP.toFloat(), context.resources.displayMetrics).toInt()
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint?.let {
            //设置颜色
            it.setColor(Color.BLUE)
            //设置填充（实心）
            it.setStyle(Paint.Style.FILL)
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (mOrientation == LinearLayoutManager.VERTICAL){
            drawVertical(c, parent)
        }else{
            drawHorizontal(c, parent)
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {


    }

    /**
     * 设置分割线的大小
     */
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if(mOrientation == LinearLayoutManager.VERTICAL){
            outRect.set(0,0,0,mItemSize);
        }else {
            outRect.set(0,0,mItemSize,0);
        }
    }

    /**
     * 绘制垂直排列的分割线
     */
    private fun drawVertical(c: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft  //获取左边内边距
        val right = parent.measuredWidth - parent.paddingRight
        val childSize = parent.childCount   //获取有多少个item
        for (i in 0 until childSize){   //遍历每个item
            val view = parent.getChildAt(i)    //获取每个item
            //设置控件参数
            val layoutParams = view.layoutParams as RecyclerView.LayoutParams
            val top = view.bottom + layoutParams.bottomMargin
            val bottom = top + mItemSize
            c.drawRect(left.toFloat(),top.toFloat(),right.toFloat(),bottom.toFloat(),mPaint)
        }
    }

    /**
     * 绘制水平排列的分割线
     */
    private fun drawHorizontal(c: Canvas, parent: RecyclerView) {
        val top = parent.paddingTop
        val bottom = parent.measuredHeight - parent.paddingBottom
        val childSize = parent.childCount
        for (i in 0 until childSize){
            val view = parent.getChildAt(i)
            val layoutParams = view.layoutParams as RecyclerView.LayoutParams
            val left = view.right + layoutParams.rightMargin
            val right = left + mItemSize
            c.drawRect(left.toFloat(),top.toFloat(),right.toFloat(),bottom.toFloat(),mPaint)
        }
    }


}