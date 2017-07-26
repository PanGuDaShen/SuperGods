package com.rmbmiss.app.mian.activity

import android.content.Intent
import android.os.Environment
import android.view.View
import android.widget.Toast
import co.aenterhy.toggleswitch.ToggleSwitchButton
import com.blankj.utilcode.util.LogUtils
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.adapter.SampleFragmentPagerAdapter
import com.rmbmiss.app.mian.base.BaseSuperActivity
import com.rmbmiss.app.mian.databean.SamplePagerItem
import com.rmbmiss.lib.utils.pathtools.DirPathTools
import com.rmbmiss.nicetablibrary.NiceTabLayout
import com.rmbmiss.nicetablibrary.NiceTabStrip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseSuperActivity() ,NiceTabStrip.OnIndicatorColorChangedListener
{

    private val mTexts = mutableListOf<String>("0000000000","11111111111111","222222222","3333333333333333333","444444","55","66","77")
    private val mIconRound = mutableListOf<Int>(R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher
            ,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher)
    private val mIcon = mutableListOf<Int>(R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round
            ,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round)
    private val mColor = mutableListOf<Int>(R.color.colorAccent,R.color.colorAccent,R.color.colorAccent,R.color.colorAccent,
            R.color.colorAccent,R.color.colorAccent,R.color.colorAccent,R.color.colorAccent)
    private val mClolorRound = mutableListOf<Int>(R.color.colorPrimary,R.color.colorPrimary,R.color.colorPrimary,R.color.colorPrimary,
            R.color.colorPrimary,R.color.colorPrimary,R.color.colorPrimary,R.color.colorPrimary)
    private val mBageMap = mutableMapOf<Int,String>(1 to "1",2 to "12",3 to "123",4 to "1234")

    private val mTabs = mutableListOf<SamplePagerItem>()    //tab 列表

    override fun setLayoutView(): Int {
        return R.layout.activity_main
    }

    override fun initEvent() {
        id_main_ntl_1.let {
            it.setTabStripColorize(object: NiceTabStrip.TabStripColorize{
                override fun getIndicatorColor(position: Int): Int {
                    return mTabs[position].getIndicatorColor()
                }

                override fun getDividerColor(position: Int): Int {
                    return mTabs[position].getDividerColor()
                }
            })
//
//        it.setTabColorize(object : NiceTabLayout.TabColorize{
//            override fun getDefaultTabColor(position: Int): Int {
//                return Color.WHITE
//            }
//
//            override fun getSelectedTabColor(position: Int): Int {
//                return mTabs[position].getIndicatorColor()
//            }
//
//        })
            it.setOnIndicatorColorChangedListener(this)
        }

        id_main_tsb_1.setOnTriggerListener(object : ToggleSwitchButton.OnTriggerListener {
            override fun toggledUp() {
                startActivity(Intent(applicationContext,NavigationActivity::class.java))
            }

            override fun toggledDown() {
                startActivity(Intent(applicationContext,SetUpActivity::class.java))
            }
        })
    }

    override fun initData() {
        for (i in 0 until mTexts.size){
            mTabs.add(i, SamplePagerItem(mTexts[i],mIcon[i],mIconRound[i],mColor[i],mClolorRound[i]))
        }
        id_mian_vp_1.adapter = SampleFragmentPagerAdapter(mTabs,supportFragmentManager)
        id_main_ntl_1.setViewPager(id_mian_vp_1)
        invaliBadge(mBageMap)
    }

    /**
     * 颜色监听
     * @param color 当前渐变颜色值
     */
    override fun onIndicatorColorChanged(tabLayout: NiceTabLayout?, color: Int) {

    }

    /**
     * 设置信息提示个数
     */
    fun invaliBadge(map: MutableMap<Int,String>){
        map?.let {
            it.forEach {
                //key 代表第几个item  ，value 代表显示的内容
                id_main_ntl_1.setBadge(it.key,it.value)
            }
            // 总共要显示内容的个数
            id_main_ntl_1.setBadgeSmall(it.size)
        }
    }

    /**
     * 清除设置信息提示个数
     */
    fun clearBadge() {
        id_main_ntl_1.clearBadge()
    }

    /**
     * 重新绘制（刷新界面）控件
     */
    fun invalidateBlur() {
        id_main_ntl_1.invalidateBlur()
    }

}
