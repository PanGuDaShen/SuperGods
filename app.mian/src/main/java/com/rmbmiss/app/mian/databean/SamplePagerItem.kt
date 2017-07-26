package com.rmbmiss.app.mian.databean

import com.rmbmiss.app.mian.base.BaseDatabean

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：NiceTabLayout 自定义控件 item tab 管理类
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/20$ 10:07$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/20$ 10:07$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class SamplePagerItem(title:CharSequence,iosIconResId:Int, androidIconResId:Int, indicatorColor:Int, dividerColor:Int):BaseDatabean(){

    private var mTitle: CharSequence    //文字
    private var mIosIconResId: Int  //原图
    private var mAndroidIconResId: Int  //替图
    private var mIndicatorColor: Int    //原色
    private var mDividerColor: Int  //替色

    init {
        mTitle = title
        mIosIconResId = iosIconResId
        mAndroidIconResId = androidIconResId
        mIndicatorColor = indicatorColor
        mDividerColor = dividerColor
    }

    fun setTitle(title:CharSequence) {
        mTitle = title
    }

    fun setIosIconResId(iosIconResId:Int) {
        mIosIconResId = iosIconResId
    }

    fun setAndroidIconResId(androidIconResId:Int) {
        mAndroidIconResId = androidIconResId
    }

    fun setIndicatorColor(indicatorColor:Int) {
        mIndicatorColor = indicatorColor
    }

    fun setDividerColor(dividerColor:Int) {
        mDividerColor = dividerColor
    }

    fun getTitle(): CharSequence {
        return mTitle
    }

    fun getIosIconResId(): Int {
        return mIosIconResId
    }

    fun getAndroidIconResId(): Int {
        return mAndroidIconResId
    }

    fun getIndicatorColor(): Int {
        return mIndicatorColor
    }

    fun getDividerColor(): Int {
        return mDividerColor
    }
}