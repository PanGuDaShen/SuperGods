package com.rmbmiss.app.mian.adapter

import android.content.Context
import android.view.ViewGroup
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.base.BaseAbstartViewHolder
import com.rmbmiss.app.mian.base.BaseRecyclerAdapter
import com.rmbmiss.app.mian.databean.NavigationDatabean
import com.rmbmiss.app.mian.hodler.NavigationBoolHolder
import com.rmbmiss.app.mian.hodler.NavigationColorHolder
import com.rmbmiss.app.mian.hodler.NavigationDimsHolder
import com.rmbmiss.app.mian.hodler.NavigationMacthHolder

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
class NavigationAdapter<T, VH : BaseAbstartViewHolder<T>>(that: Context, datas: MutableList<T>?) : BaseRecyclerAdapter<T, VH>(that, datas) {
    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): VH? {
        val ss = mDatas.get(viewType) as NavigationDatabean
        when(ss.key){
            "ntlTabDistributeEvenly"  -> { getNavigationBoolHolder(parent) } //boolean：0=true， 1=false
            "ntlDrawOrder"  -> { getNavigationMacthHolder(parent) } //enum:0=indicatorUnderlineDivider,1=indicatorDividerUnderline,
                // 2=underlineIndicatorDivider,3=underlineDividerIndicator,4=dividerIndicatorUnderline,5=dividerUnderlineIndicator
            "ntlTabMode"  -> { getNavigationMacthHolder(parent) } //enum：0=titleOnly，1=iconOnly，2=both
            "ntlTabColorBlendMode"  -> { getNavigationMacthHolder(parent) } //enum：0=none，1=defaultSelected，2=nextSelected
            "ntlTabBackground"  -> { getNavigationColorHolder(parent) } //reference|color
            "ntlTabOffset"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlTabSelectedCenter"  -> { getNavigationBoolHolder(parent) } //boolean：0=true， 1=false
            "ntlShowUnderline"  -> { getNavigationBoolHolder(parent) } //boolean：0=true， 1=false
            "ntlUnderlineInFront"  -> { getNavigationBoolHolder(parent) } //boolean：0=true， 1=false
            "ntlUnderlineGravity"  -> { getNavigationMacthHolder(parent) } //enum：0=top， 1=bottom
            "ntlUnderlineColor"  -> { getNavigationColorHolder(parent) } //color
            "ntlUnderlineHeight"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlUnderlinePaddingTop"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlUnderlinePaddingBottom"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlShowDivider"  -> { getNavigationBoolHolder(parent) } //boolean：0=true， 1=false
            "ntlDividerColor"  -> { getNavigationColorHolder(parent) } //color
            "ntlDividerColors"  -> { getNavigationColorHolder(parent) } //reference
            "ntlDividerWidth"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlDividerPadding"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlDividerPaddingTop"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlDividerPaddingBottom"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlDividerPaddingLeft"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlDividerPaddingRight"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlShowIndicator"  -> { getNavigationBoolHolder(parent) } //boolean：0=true， 1=false
            "ntlIndicatorGravity"  -> { getNavigationMacthHolder(parent) } //enum:0=top,1=center,2=bottom
            "ntlIndicatorColor"  -> { getNavigationColorHolder(parent) } //color
            "ntlIndicatorColors"  -> { getNavigationColorHolder(parent) } //reference
            "ntlIndicatorHeight"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlIndicatorCornerRadius"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlIndicatorPaddingTop"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlIndicatorPaddingBottom"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlDefaultTabColor"  -> { getNavigationColorHolder(parent) } //color
            "ntlDefaultTabColors"  -> { getNavigationColorHolder(parent) } //reference
            "ntlSelectedTabColor"  -> { getNavigationColorHolder(parent) } //color
            "ntlSelectedTabColors"  -> { getNavigationColorHolder(parent) } //reference
            "ntlTabPadding"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlTabPaddingTop"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlTabPaddingBottom"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlTabPaddingLeft"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlTabPaddingRight"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlTabViewLayoutId"  -> { getNavigationColorHolder(parent) } //reference
            "ntlTabViewTextOrImageViewId"  -> { getNavigationColorHolder(parent) } //reference
            "ntlDrawablePadding"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlTextSize"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlTextAllCaps"  -> { getNavigationBoolHolder(parent) } //boolean：0=true， 1=false
            "ntlTextStyle"  -> { getNavigationMacthHolder(parent) } //enum:0=normal,1=bold,2=italic,3=boldItalic
            "ntlIconCrossFade"  -> { getNavigationBoolHolder(parent) } //boolean：0=true， 1=false
            "ntlIconTint"  -> { getNavigationBoolHolder(parent) } //boolean：0=true， 1=false
            "ntlBlurRadius"  -> { getNavigationDimsHolder(parent) } //integer
            "ntlDownSampleFactor"  -> { getNavigationDimsHolder(parent) } //integer
            "ntlOverlayColor"  -> { getNavigationColorHolder(parent) } //color
            "ntlBadgeGravity"  -> { getNavigationMacthHolder(parent) } //enum:0=left,1=center_left,2=center_right,3=right
            "ntlBadgeTextColor"  -> { getNavigationColorHolder(parent) } //color
            "ntlBadgeTextSize"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlBadgeHeight"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlBadgeCornerRadius"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlBadgeMinWidth"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlBadgeMaxWidth"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlBadgeMarginLeft"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlBadgeMarginRight"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlBadgeMarginTop"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlBadgePaddingLeftRight"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlBadgeSmallSize"  -> { getNavigationDimsHolder(parent) } //dimension
            "ntlBadgeBackground"  -> { getNavigationColorHolder(parent) } //reference|color
        }
        return null
    }

    /**
     * 值多选
     */
    fun getNavigationMacthHolder(parent: ViewGroup?) = NavigationMacthHolder<T>(mContext, mInflater.inflate(R.layout.rvtype_navigation_one, parent, false)) as VH

    /**
     * boolean 2选1
     */
    fun getNavigationBoolHolder(parent: ViewGroup?) = NavigationBoolHolder<T>(mContext, mInflater.inflate(R.layout.rvtype_navigation_one, parent, false)) as VH

    /**
     * 单位长度
     */
    fun getNavigationDimsHolder(parent: ViewGroup?) = NavigationDimsHolder<T>(mContext, mInflater.inflate(R.layout.rvtype_navigation_one, parent, false)) as VH

    /**
     * 颜色选择
     */
    fun getNavigationColorHolder(parent: ViewGroup?) = NavigationColorHolder<T>(mContext, mInflater.inflate(R.layout.rvtype_navigation_one, parent, false)) as VH

}