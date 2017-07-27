package com.rmbmiss.app.mian.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.blankj.utilcode.util.LogUtils

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：RecyclerView万能数据装配器【继承基类】,T为封装的数据类型，根据传入的数据类型决定。
 * 创 建 人：IMissYou
 * 创建时间：2017/5/27 16:01
 * 修 改 人：IMissYou
 * 修改时间：2017/5/27 16:01
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
abstract class BaseHFAbstartViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected var mContext: Context? = null

    /**
     * 绑定头部数据,有需要时子类可以重写。
     */
    open fun bindHeader(person: Any?){
        LogUtils.d(" bindHeader 被调用了。")
    }

    /**
     * 绑定尾部数据,有需要时子类可以重写。
     */
    open fun bindFooter(person: Any?){
        LogUtils.d(" bindFooter 被调用了。")
    }

    /**
     * 绑定其他数据，这个使用的比较多，所以抽象。
     */
    abstract fun bindHolder(person: T)

}