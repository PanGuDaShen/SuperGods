package com.rmbmiss.app.mian.activity

import android.support.v7.widget.LinearLayoutManager
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.adapter.SetUpAdapter
import com.rmbmiss.app.mian.base.BaseSuperActivity
import com.rmbmiss.app.mian.databean.SetUpDatabean
import com.rmbmiss.app.mian.hodler.SetUpHolder
import com.rmbmiss.lib.utils.viewtools.RecyclerViewTools
import kotlinx.android.synthetic.main.activity_setup.*

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：App设置页面
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/21$ 10:21$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/21$ 10:21$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class SetUpActivity :BaseSuperActivity() {

    private var mSetupAdapter: SetUpAdapter<SetUpDatabean,SetUpHolder<SetUpDatabean>>?=null
    private val mList = mutableListOf<SetUpDatabean>()

    override fun setLayoutView(): Int {
        return R.layout.activity_setup
    }

    override fun initEvent() {

    }

    override fun initData() {
        for (i in 0.. 1){
            val map = mutableMapOf<CharSequence,Class<*>>("导航栏设置" to NavigationActivity::class.java)
            val setUpDatabean = SetUpDatabean(0,"菜单",map)
            mList.add(i, setUpDatabean)
        }
        id_main_rv_1?.let {
            mSetupAdapter = SetUpAdapter(applicationContext,mList)
            RecyclerViewTools.setRvLinear(this,it,LinearLayoutManager.VERTICAL).adapter = mSetupAdapter
        }
    }

}