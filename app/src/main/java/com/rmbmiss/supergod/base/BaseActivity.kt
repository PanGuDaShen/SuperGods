package com.rmbmiss.supergod.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.TypedValue
import android.view.MenuItem
import android.view.View
import android.view.Window
import com.rmbmiss.supergod.R

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou
 * 创建时间：2017/5/26 9:34
 * 修 改 人：IMissYou
 * 修改时间：2017/5/26 9:34
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
abstract class BaseActivity: AppCompatActivity(){
    private var dialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystemBarTint()
    }

    /**
     * 手机物理按键，或者华为的虚拟按键事件处理。
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId){
            android.R.id.home -> finish()    // 点击手机自带返回图标事件
            android.R.id.hint -> {} //不知道是什么不处理
            else ->return super.onOptionsItemSelected(item)    //都不是系统处理
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * 子类不可以重写改变状态栏颜色[子类只能使用protected]
     */
    private fun setStatusBarColor(): Int{
        return getColorPrimary()
    }

    /**
     * 子类可以重写决定是否使用透明状态栏[子类可以被重写则使用open]
     */
    open fun translucentStatusBar(): Boolean{
        return false
    }

    /**
     * 子类可以重写方法决定是否使用沉侵式状态了
     */
    open fun setWhenMarried(): Boolean{
        return false
    }

    /**
     * 获取主题色
     */
    private fun getColorPrimary(): Int {
        val typedValue = TypedValue()
        theme.resolveAttribute(R.attr.colorPrimaryDark,typedValue,true)
        return typedValue.data
    }

    private fun initSystemBarTint() {
        addBarUtils()
        removeBarUtils()
    }

    /**
     * 添加状态栏设置
     */
    abstract fun addBarUtils()

    /**
     * 移除状态栏设置
     */
    abstract fun removeBarUtils()

    /**
     * 泛型方法，替代系统的findViewById（），不过不是很必要，kotlin已经有关联xml库。
     */
    fun <T:View> findView(id: Int): T {
        return findViewById(id) as T
    }

    /**
     * 初始化 Toolbar
     */
    fun initToolBar(toolbar: Toolbar,homeAsUpEnabled: Boolean,title: String){
        toolbar.title = title
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(homeAsUpEnabled)
    }

    fun initToolBar(toolbar: Toolbar, homeAsUpEnabled: Boolean, resTitle: Int) {
        initToolBar(toolbar, homeAsUpEnabled, getString(resTitle))
    }

    /**
     * 显示弹窗
     */
    fun showLoading(){
        if (dialog != null && dialog!!.isShowing) {
            return
        }
        dialog = ProgressDialog(this)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setCanceledOnTouchOutside(false)
        dialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        dialog!!.setMessage("请求网络中...")
        dialog!!.show()
    }

    /**
     * 关闭弹窗
     */
    fun dismissLoading(){
        if (dialog != null && dialog!!.isShowing()) {
            dialog!!.dismiss()
        }
    }

}