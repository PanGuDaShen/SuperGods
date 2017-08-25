package com.rmbmiss.lib.utils.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.DisplayMetrics
import android.view.*

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/8/2$ 16:05$
 * 修 改 人：IMissYou$
 * 修改时间：2017/8/2$ 16:05$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
abstract class BaseDialogFragment:DialogFragment() {

    protected var lat:Int = -1
    protected var styleAnimont = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (setBoolean()) {
            // 无标题栏设置
        setStyle(DialogFragment.STYLE_NO_TITLE,setStyleDialog())
            // 全屏设置
//        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        }
        initBundle(savedInstanceState)
    }

    open fun setBoolean(): Boolean{
        return false
    }

    /**
     * 设置dialog主题
     */
    open fun setStyleDialog(): Int{
        return 0
    }

    /**
     * 解析传入的数据
     */
    open fun initBundle(savedInstanceState: Bundle?){}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (!setBoolean()) {
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        }
        if (styleAnimont != 1)dialog.window.setWindowAnimations(styleAnimont)
        val v = inflater.inflate(getLayoutRes(), container, false)

        bindView(v)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bindEvent()
        bindData()
    }

    override fun onStart() {
        super.onStart()
        // 设置可以全屏
        val dm = DisplayMetrics()
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.parseColor("#00000000")))
        activity.windowManager.defaultDisplay.getMetrics(dm)
        dialog.window.setLayout(dm.widthPixels,dialog.window.attributes.height)
    }
    /**
     * 加载视图
     */
    abstract fun getLayoutRes(): Int

    /**
     * 获取控件
     */
    abstract fun bindView(v: View)

    /**
     * 绑定事件
     */
    abstract fun bindEvent()

    /**
     * 绑定数据
     */
    abstract fun bindData()


}