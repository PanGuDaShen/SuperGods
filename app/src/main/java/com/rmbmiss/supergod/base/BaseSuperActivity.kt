package com.rmbmiss.supergod.base

import android.os.Bundle

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou
 * 创建时间：2017/5/27 15:18
 * 修 改 人：IMissYou
 * 修改时间：2017/5/27 15:18
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
abstract class BaseSuperActivity: BaseActivity() {

    protected val TGA = javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutView())
        initEvent()
        initData()
    }

    /**
     * 加载视图
     */
    protected abstract fun setLayoutView(): Int

    /**
     * 添加事件监听
     */
    protected abstract fun initEvent()

    /**
     * 添加数据
     */
    protected abstract fun initData()

    override fun addBarUtils() {
        if(translucentStatusBar()) {
            supportActionBar?.let { it.hide() } //确保是supportActionBar不为null，空引用方法报错
        }
        if (setWhenMarried()){

        }
    }

    override fun removeBarUtils() {

    }

    override fun translucentStatusBar(): Boolean {
        return true
    }
}