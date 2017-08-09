package com.rmbmiss.app.mian.adapter

import android.content.Context
import android.view.ViewGroup
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.base.BaseHFAbstartViewHolder
import com.rmbmiss.app.mian.base.BaseHFRecyclerAdapter
import com.rmbmiss.app.mian.hodler.NiceHodler

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/8/9$ 16:50$
 * 修 改 人：IMissYou$
 * 修改时间：2017/8/9$ 16:50$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class NiceAdapter<T, VH : BaseHFAbstartViewHolder<T>>(that: Context, datas: MutableList<T>?) : BaseHFRecyclerAdapter<T, VH>(that, datas) {
    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): VH? {
        return NiceHodler<T>(mContext, mInflater.inflate(R.layout.rvtype_navigation_one, parent, false)) as VH
    }
}