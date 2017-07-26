package com.rmbmiss.app.mian.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lzy.okgo.OkGo

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：碎片基类，子类不建议使用构造函数传值，有bug
 * 创 建 人：IMissYou
 * 创建时间：2017/5/26 14:32
 * 修 改 人：IMissYou
 * 修改时间：2017/5/26 14:32
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
abstract class BaseFragment: Fragment(),View.OnClickListener {

    private var isVisbles = false //界面是否可见
    private var isPrepared = false  //确保 showData()方法不会报空指针异常
    private var isFirst = true //isFirst确保ViewPager来回切换时BaseFragment的showData方法不会被重复调用

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(setLayout(),container,false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (arguments!=null){
            getSetArgs(arguments)
        }
        setEvent()
        setData()
    }

    open fun getSetArgs(arguments: Bundle?) {

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if(userVisibleHint){
            lazyLoad()
            isVisbles = true
        }else{
            missData()
            isVisbles = false
        }
    }

    /**
     * 加载xml布局
     */
    protected abstract fun setLayout(): Int

    /**
     * 添加事件监听
     */
    protected abstract fun setEvent()

    /**
     * 初始化数据
     */
    protected abstract fun setData()

    /**
     * 控件点击事件
     */
    protected abstract fun processClick(v: View)

    override fun onClick(v: View?) {
        processClick(v!!)
    }

    private fun lazyLoad() {
        if (!isPrepared || !isVisbles || !isFirst){
            return
        }
        showData();
        isFirst = false;
    }

    /**
     * 界面可见是加载，需要懒加载是子类重写即。
     */
    open fun showData() {
    }

    /**
     * 界面不可见处理
     */
    open fun missData() {

    }

    override fun onDestroy() {
        super.onDestroy()
        //Activity销毁时，取消网络请求
        OkGo.getInstance().cancelTag(this)
    }
}