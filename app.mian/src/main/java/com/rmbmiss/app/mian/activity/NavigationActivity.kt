package com.rmbmiss.app.mian.activity

import android.content.Context
import android.graphics.Canvas
import android.support.v7.widget.RecyclerView
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.adapter.NavigationAdapter
import com.rmbmiss.app.mian.base.BaseHFAbstartViewHolder
import com.rmbmiss.app.mian.base.BaseSuperActivity
import com.rmbmiss.app.mian.databean.NavigationDatabean
import com.rmbmiss.app.mian.databean.NavigationList
import com.rmbmiss.lib.utils.viewtools.RecyclerViewTools
import kotlinx.android.synthetic.main.activity_navigation.*
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.GridLayoutManager
import android.content.res.TypedArray
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView.State



/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：导航栏设置页面
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/21$ 14:30$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/21$ 14:30$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class NavigationActivity : BaseSuperActivity() {

    private var mNavigationAdapter: NavigationAdapter<NavigationDatabean, BaseHFAbstartViewHolder<NavigationDatabean>>?=null

    override fun setLayoutView(): Int {
        return R.layout.activity_navigation
    }

    override fun initEvent() {

    }

    override fun initData() {
        mNavigationAdapter = NavigationAdapter(applicationContext,NavigationList.list)
        id_main_rv_2?.let {
            RecyclerViewTools.setRvLinear(this,it,-1).adapter = mNavigationAdapter
        }
    }

}