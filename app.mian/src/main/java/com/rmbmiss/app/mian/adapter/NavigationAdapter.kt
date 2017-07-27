package com.rmbmiss.app.mian.adapter

import android.content.Context
import android.view.ViewGroup
import com.blankj.utilcode.util.LogUtils
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.base.BaseHFAbstartViewHolder
import com.rmbmiss.app.mian.base.BaseHFRecyclerAdapter
import com.rmbmiss.app.mian.databean.NavigationDatabean
import com.rmbmiss.app.mian.hodler.NavigationBoolHolder
import com.rmbmiss.app.mian.hodler.NavigationColorHolder
import com.rmbmiss.app.mian.hodler.NavigationDimsHolder
import com.rmbmiss.app.mian.hodler.NavigationMacthHolder
import com.rmbmiss.lib.utils.errortools.ErrorStringTools

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou
 * 创建时间：2017/7/26 16:27
 * 修 改 人：IMissYou
 * 修改时间：2017/7/26 16:27
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class NavigationAdapter<T, VH : BaseHFAbstartViewHolder<T>>(that: Context, datas: MutableList<T>?) : BaseHFRecyclerAdapter<T, VH>(that, datas) {

    private val BOOL = 0
    private val MACTH = 1
    private val COLOR = 2
    private val DIMS = 4


    override fun getItemType(position: Int): Int {
        val key = (mDatas?.get(position) as NavigationDatabean).key
        LogUtils.e(key+"======$position")
        when(key) {
            "ntlTabDistributeEvenly" -> {
                return BOOL
            } //boolean：0=true， 1=false
            "ntlDrawOrder" -> {
                return MACTH
            } //enum:0=indicatorUnderlineDivider,1=indicatorDividerUnderline,
        // 2=underlineIndicatorDivider,3=underlineDividerIndicator,4=dividerIndicatorUnderline,5=dividerUnderlineIndicator
            "ntlTabMode" -> {
                return MACTH
            } //enum：0=titleOnly，1=iconOnly，2=both
            "ntlTabColorBlendMode" -> {
                return MACTH
            } //enum：0=none，1=defaultSelected，2=nextSelected
            "ntlTabBackground" -> {
                return COLOR
            } //reference|color
            "ntlTabOffset" -> {
                return DIMS
            } //dimension
            "ntlTabSelectedCenter" -> {
                return BOOL
            } //boolean：0=true， 1=false
            "ntlShowUnderline" -> {
                return BOOL
            } //boolean：0=true， 1=false
            "ntlUnderlineInFront" -> {
                return BOOL
            } //boolean：0=true， 1=false
            "ntlUnderlineGravity" -> {
                return MACTH
            } //enum：0=top， 1=bottom
            "ntlUnderlineColor" -> {
                return COLOR
            } //color
            "ntlUnderlineHeight" -> {
                return DIMS
            } //dimension
            "ntlUnderlinePaddingTop" -> {
                return DIMS
            } //dimension
            "ntlUnderlinePaddingBottom" -> {
                return DIMS
            } //dimension
            "ntlShowDivider" -> {
                return BOOL
            } //boolean：0=true， 1=false
            "ntlDividerColor" -> {
                return COLOR
            } //color
            "ntlDividerColors" -> {
                return COLOR
            } //reference
            "ntlDividerWidth" -> {
                return DIMS
            } //dimension
            "ntlDividerPadding" -> {
                return DIMS
            } //dimension
            "ntlDividerPaddingTop" -> {
                return DIMS
            } //dimension
            "ntlDividerPaddingBottom" -> {
                return DIMS
            } //dimension
            "ntlDividerPaddingLeft" -> {
                return DIMS
            } //dimension
            "ntlDividerPaddingRight" -> {
                return DIMS
            } //dimension
            "ntlShowIndicator" -> {
                return BOOL
            } //boolean：0=true， 1=false
            "ntlIndicatorGravity" -> {
                return MACTH
            } //enum:0=top,1=center,2=bottom
            "ntlIndicatorColor" -> {
                return COLOR
            } //color
            "ntlIndicatorColors" -> {
                return COLOR
            } //reference
            "ntlIndicatorHeight" -> {
                return DIMS
            } //dimension
            "ntlIndicatorCornerRadius" -> {
                return DIMS
            } //dimension
            "ntlIndicatorPaddingTop" -> {
                return DIMS
            } //dimension
            "ntlIndicatorPaddingBottom" -> {
                return DIMS
            } //dimension
            "ntlDefaultTabColor" -> {
                return COLOR
            } //color
            "ntlDefaultTabColors" -> {
                return COLOR
            } //reference
            "ntlSelectedTabColor" -> {
                return COLOR
            } //color
            "ntlSelectedTabColors" -> {
                return COLOR
            } //reference
            "ntlTabPadding" -> {
                return DIMS
            } //dimension
            "ntlTabPaddingTop" -> {
                return DIMS
            } //dimension
            "ntlTabPaddingBottom" -> {
                return DIMS
            } //dimension
            "ntlTabPaddingLeft" -> {
                return DIMS
            } //dimension
            "ntlTabPaddingRight" -> {
                return DIMS
            } //dimension
            "ntlTabViewLayoutId" -> {
                return COLOR
            } //reference
            "ntlTabViewTextOrImageViewId" -> {
                return COLOR
            } //reference
            "ntlDrawablePadding" -> {
                return DIMS
            } //dimension
            "ntlTextSize" -> {
                return DIMS
            } //dimension
            "ntlTextAllCaps" -> {
                return BOOL
            } //boolean：0=true， 1=false
            "ntlTextStyle" -> {
                return MACTH
            } //enum:0=normal,1=bold,2=italic,3=boldItalic
            "ntlIconCrossFade" -> {
                return BOOL
            } //boolean：0=true， 1=false
            "ntlIconTint" -> {
                return BOOL
            } //boolean：0=true， 1=false
            "ntlBlurRadius" -> {
                return DIMS
            } //integer
            "ntlDownSampleFactor" -> {
                return DIMS
            } //integer
            "ntlOverlayColor" -> {
                return COLOR
            } //color
            "ntlBadgeGravity" -> {
                return MACTH
            } //enum:0=left,1=center_left,2=center_right,3=right
            "ntlBadgeTextColor" -> {
                return COLOR
            } //color
            "ntlBadgeTextSize" -> {
                return DIMS
            } //dimension
            "ntlBadgeHeight" -> {
                return DIMS
            } //dimension
            "ntlBadgeCornerRadius" -> {
                return DIMS
            } //dimension
            "ntlBadgeMinWidth" -> {
                return DIMS
            } //dimension
            "ntlBadgeMaxWidth" -> {
                return DIMS
            } //dimension
            "ntlBadgeMarginLeft" -> {
                return DIMS
            } //dimension
            "ntlBadgeMarginRight" -> {
                return DIMS
            } //dimension
            "ntlBadgeMarginTop" -> {
                return DIMS
            } //dimension
            "ntlBadgePaddingLeftRight" -> {
                return DIMS
            } //dimension
            "ntlBadgeSmallSize" -> {
                return DIMS
            } //dimension
            "ntlBadgeBackground" -> {
                return COLOR
            } //reference|color
            else -> {
                ErrorStringTools.showString("NavigationAdapter 的类型值错误！")
            }
        }
        return BOOL
    }

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): VH {
        LogUtils.e("viewType==================================$viewType")
        when(viewType){
            BOOL -> return getNavigationBoolHolder(parent)
            MACTH -> return getNavigationMacthHolder(parent)
            COLOR -> return getNavigationColorHolder(parent)
            DIMS -> return getNavigationDimsHolder(parent)
        }
        return getNavigationDimsHolder(parent)
    }

    /**
     * 值多选
     */
    fun getNavigationMacthHolder(parent: ViewGroup?) = NavigationMacthHolder<T>(mContext!!, mInflater.inflate(R.layout.rvtype_navigation_three, parent, false)) as VH

    /**
     * boolean 2选1
     */
    fun getNavigationBoolHolder(parent: ViewGroup?) = NavigationBoolHolder<T>(mContext!!, mInflater.inflate(R.layout.rvtype_navigation_one, parent, false)) as VH

    /**
     * 单位长度
     */
    fun getNavigationDimsHolder(parent: ViewGroup?) = NavigationDimsHolder<T>(mContext!!, mInflater.inflate(R.layout.rvtype_navigation_four, parent, false)) as VH

    /**
     * 颜色选择
     */
    fun getNavigationColorHolder(parent: ViewGroup?) = NavigationColorHolder<T>(mContext!!, mInflater.inflate(R.layout.rvtype_navigation_two, parent, false)) as VH

}