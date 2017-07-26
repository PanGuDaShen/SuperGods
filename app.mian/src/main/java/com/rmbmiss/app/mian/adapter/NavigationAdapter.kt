package com.rmbmiss.app.mian.adapter

import android.content.Context
import android.view.ViewGroup
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.base.BaseAbstartViewHolder
import com.rmbmiss.app.mian.base.BaseRecyclerAdapter
import com.rmbmiss.app.mian.databean.NavigationDatabean
import com.rmbmiss.app.mian.hodler.NavigationMacthHolder

/**
 * Created by Administrator on 2017/7/25.
 */
class NavigationAdapter<T, VH : BaseAbstartViewHolder<T>>(that: Context, datas: MutableList<T>?) : BaseRecyclerAdapter<T, VH>(that, datas) {
    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): VH? {
        val ss = mDatas.get(viewType) as NavigationDatabean<String, Any?>
        when(ss.key){
            "ntlTabDistributeEvenly"  -> {  } //boolean：0=true， 1=false
            "ntlDrawOrder"  -> {  } //enum:0=indicatorUnderlineDivider,1=indicatorDividerUnderline,
                // 2=underlineIndicatorDivider,3=underlineDividerIndicator,4=dividerIndicatorUnderline,5=dividerUnderlineIndicator
            "ntlTabMode"  -> {  } //enum：0=titleOnly，1=iconOnly，2=both
            "ntlTabColorBlendMode"  -> {  } //enum：0=none，1=defaultSelected，2=nextSelected
            "ntlTabBackground"  -> {  } //reference|color
            "ntlTabOffset"  -> {  } //dimension
            "ntlTabSelectedCenter"  -> {  } //boolean：0=true， 1=false
            "ntlShowUnderline"  -> {  } //boolean：0=true， 1=false
            "ntlUnderlineInFront"  -> {  } //boolean：0=true， 1=false
            "ntlUnderlineGravity"  -> {  } //enum：0=top， 1=bottom
            "ntlUnderlineColor"  -> {  } //color
            "ntlUnderlineHeight"  -> {  } //dimension
            "ntlUnderlinePaddingTop"  -> {  } //dimension
            "ntlUnderlinePaddingBottom"  -> {  } //dimension
            "ntlShowDivider"  -> {  } //boolean：0=true， 1=false
            "ntlDividerColor"  -> {  } //color
            "ntlDividerColors"  -> {  } //reference
            "ntlDividerWidth"  -> {  } //dimension
            "ntlDividerPadding"  -> {  } //dimension
            "ntlDividerPaddingTop"  -> {  } //dimension
            "ntlDividerPaddingBottom"  -> {  } //dimension
            "ntlDividerPaddingLeft"  -> {  } //dimension
            "ntlDividerPaddingRight"  -> {  } //dimension
            "ntlShowIndicator"  -> {  } //boolean：0=true， 1=false
            "ntlIndicatorGravity"  -> {  } //enum:0=top,1=center,2=bottom
            "ntlIndicatorColor"  -> {  } //color
            "ntlIndicatorColors"  -> {  } //reference
            "ntlIndicatorHeight"  -> {  } //dimension
            "ntlIndicatorCornerRadius"  -> {  } //dimension
            "ntlIndicatorPaddingTop"  -> {  } //dimension
            "ntlIndicatorPaddingBottom"  -> {  } //dimension
            "ntlDefaultTabColor"  -> {  } //color
            "ntlDefaultTabColors"  -> {  } //reference
            "ntlSelectedTabColor"  -> {  } //color
            "ntlSelectedTabColors"  -> {  } //reference
            "ntlTabPadding"  -> {  } //dimension
            "ntlTabPaddingTop"  -> {  } //dimension
            "ntlTabPaddingBottom"  -> {  } //dimension
            "ntlTabPaddingLeft"  -> {  } //dimension
            "ntlTabPaddingRight"  -> {  } //dimension
            "ntlTabViewLayoutId"  -> {  } //reference
            "ntlTabViewTextOrImageViewId"  -> {  } //reference
            "ntlDrawablePadding"  -> {  } //dimension
            "ntlTextSize"  -> {  } //dimension
            "ntlTextAllCaps"  -> {  } //boolean：0=true， 1=false
            "ntlTextStyle"  -> {  } //enum:0=normal,1=bold,2=italic,3=boldItalic
            "ntlIconCrossFade"  -> {  } //boolean：0=true， 1=false
            "ntlIconTint"  -> {  } //boolean：0=true， 1=false
            "ntlBlurRadius"  -> {  } //integer
            "ntlDownSampleFactor"  -> {  } //integer
            "ntlOverlayColor"  -> {  } //color
            "ntlBadgeGravity"  -> {  } //enum:0=left,1=center_left,2=center_right,3=right
            "ntlBadgeTextColor"  -> {  } //color
            "ntlBadgeTextSize"  -> {  } //dimension
            "ntlBadgeHeight"  -> {  } //dimension
            "ntlBadgeCornerRadius"  -> {  } //dimension
            "ntlBadgeMinWidth"  -> {  } //dimension
            "ntlBadgeMaxWidth"  -> {  } //dimension
            "ntlBadgeMarginLeft"  -> {  } //dimension
            "ntlBadgeMarginRight"  -> {  } //dimension
            "ntlBadgeMarginTop"  -> {  } //dimension
            "ntlBadgePaddingLeftRight"  -> {  } //dimension
            "ntlBadgeSmallSize"  -> {  } //dimension
            "ntlBadgeBackground"  -> {  } //reference|color
        }
        return NavigationMacthHolder<T>(mContext, mInflater.inflate(R.layout.rvtype_navigation_one, parent, false)) as VH
    }

    fun getNavigationHolder(parent: ViewGroup?) = NavigationMacthHolder<T>(mContext, mInflater.inflate(R.layout.rvtype_navigation_one, parent, false)) as VH

}