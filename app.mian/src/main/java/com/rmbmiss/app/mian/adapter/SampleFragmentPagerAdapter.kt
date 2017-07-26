package com.rmbmiss.app.mian.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.blankj.utilcode.util.LogUtils
import com.rmbmiss.app.mian.base.BaseFragment
import com.rmbmiss.app.mian.databean.SamplePagerItem
import com.rmbmiss.app.mian.fragment.InsFragment
import com.rmbmiss.nicetablibrary.NiceTabLayout

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：NiceTabLayout自定义控件适配器
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/20$ 9:59$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/20$ 9:59$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class SampleFragmentPagerAdapter(tabs:MutableList<SamplePagerItem>, fm:FragmentManager):FragmentPagerAdapter(fm),NiceTabLayout.IconTabProvider {
    private var mIosStyleIcon:Boolean = false
    private var mTabs = mutableListOf<SamplePagerItem>()    //tab 列表
    private var mFragment = mutableListOf<InsFragment>()   //页面 集合

    init {
        if (mTabs!=null){
            mTabs.clear()
        }
        mTabs = tabs
        for(i in 0 until mTabs.size){
            mFragment.add(i, InsFragment.newInstance(mTabs[i].getTitle()))
        }
    }

    fun setMtabs(tabs:MutableList<SamplePagerItem>){
        if (mTabs!=null){
            mTabs.clear()
        }
        if (mFragment!=null){
            mFragment.clear()
        }
        mTabs = tabs
    }

    fun getMtabs():MutableList<SamplePagerItem>{
        return mTabs
    }

    override fun getItem(position: Int): Fragment {

        return mFragment[position]
    }

    override fun getCount(): Int {
        return mTabs.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTabs[position].getTitle()
    }

    override fun getPageIconResId(position: Int): Int {
        if (mIosStyleIcon){
            return mTabs[position].getIosIconResId()
        }else{
            return mTabs[position].getAndroidIconResId()
        }
        return  mTabs[position].getAndroidIconResId()
    }
}