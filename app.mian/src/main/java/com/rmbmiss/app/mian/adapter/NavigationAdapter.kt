package com.rmbmiss.app.mian.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.Toast
import com.blankj.utilcode.util.LogUtils
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.base.BaseHFAbstartViewHolder
import com.rmbmiss.app.mian.base.BaseHFRecyclerAdapter
import com.rmbmiss.app.mian.click.OnClickface
import com.rmbmiss.app.mian.databean.NavigationDatabean
import com.rmbmiss.app.mian.hodler.NavigationBoolHolder
import com.rmbmiss.app.mian.hodler.NavigationColorHolder
import com.rmbmiss.app.mian.hodler.NavigationDimsHolder
import com.rmbmiss.app.mian.hodler.NavigationMacthHolder
import com.rmbmiss.lib.utils.errortools.ErrorStringTools
import com.rmbmiss.lib.utils.sqltools.DBHelper

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
class NavigationAdapter<T, VH : BaseHFAbstartViewHolder<T>>(that: Context, datas: MutableList<T>?) : BaseHFRecyclerAdapter<T, VH>(that, datas), OnClickface {

    companion object {
        val BOOL = 0
        val MACTH = 1
        val COLOR = 2
        val DIMS = 4
    }

    override fun getItemType(position: Int): Int {
        val key = (mDatas.get(position) as NavigationDatabean).key
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
    fun getNavigationMacthHolder(parent: ViewGroup?):VH{
        val vh = NavigationMacthHolder<T>(mContext, mInflater.inflate(R.layout.rvtype_navigation_three, parent, false))
        vh.addOnClick(this)
        return vh as VH
    }

    /**
     * boolean 2选1
     */
    fun getNavigationBoolHolder(parent: ViewGroup?):VH{
        val vh = NavigationBoolHolder<T>(mContext, mInflater.inflate(R.layout.rvtype_navigation_one, parent, false))
        vh.addOnClick(this)
        return vh as VH
    }

    /**
     * 单位长度
     */
    fun getNavigationDimsHolder(parent: ViewGroup?):VH {
        val vh = NavigationDimsHolder<T>(mContext, mInflater.inflate(R.layout.rvtype_navigation_four, parent, false))
        vh.addOnClick(this)
        return vh as VH
    }

    /**
     * 颜色选择
     */
    fun getNavigationColorHolder(parent: ViewGroup?):VH{
        val vh = NavigationColorHolder<T>(mContext, mInflater.inflate(R.layout.rvtype_navigation_two, parent, false))
        vh.addOnClick(this)
        return vh as VH
    }

//    override fun onClick(person) {
//        Toast.makeText(mContext,"type = $type ---- boolean = $boolean",Toast.LENGTH_SHORT).show()
//        setSetting(key)
//    }
    override fun <R> onClick(person: R) {
        person as NavigationDatabean
        setSetting(person.key)
    }

    fun setSetting(key:String){
        Toast.makeText(mContext,key,Toast.LENGTH_SHORT).show()
        when(key) {
            "ntlTabDistributeEvenly" -> {
               var db = DBHelper(mContext,"mian.db")
                db.writableDatabase
            } //boolean：0=true， 1=false
            "ntlDrawOrder" -> {
            } //enum:0=indicatorUnderlineDivider,1=indicatorDividerUnderline,
        // 2=underlineIndicatorDivider,3=underlineDividerIndicator,4=dividerIndicatorUnderline,5=dividerUnderlineIndicator
            "ntlTabMode" -> {
            } //enum：0=titleOnly，1=iconOnly，2=both
            "ntlTabColorBlendMode" -> {
            } //enum：0=none，1=defaultSelected，2=nextSelected
            "ntlTabBackground" -> {
            } //reference|color
            "ntlTabOffset" -> {
            } //dimension
            "ntlTabSelectedCenter" -> {
            } //boolean：0=true， 1=false
            "ntlShowUnderline" -> {
            } //boolean：0=true， 1=false
            "ntlUnderlineInFront" -> {
            } //boolean：0=true， 1=false
            "ntlUnderlineGravity" -> {
            } //enum：0=top， 1=bottom
            "ntlUnderlineColor" -> {
            } //color
            "ntlUnderlineHeight" -> {
            } //dimension
            "ntlUnderlinePaddingTop" -> {
            } //dimension
            "ntlUnderlinePaddingBottom" -> {
            } //dimension
            "ntlShowDivider" -> {
            } //boolean：0=true， 1=false
            "ntlDividerColor" -> {
            } //color
            "ntlDividerColors" -> {
            } //reference
            "ntlDividerWidth" -> {
            } //dimension
            "ntlDividerPadding" -> {
            } //dimension
            "ntlDividerPaddingTop" -> {
            } //dimension
            "ntlDividerPaddingBottom" -> {
            } //dimension
            "ntlDividerPaddingLeft" -> {
            } //dimension
            "ntlDividerPaddingRight" -> {
            } //dimension
            "ntlShowIndicator" -> {
            } //boolean：0=true， 1=false
            "ntlIndicatorGravity" -> {
            } //enum:0=top,1=center,2=bottom
            "ntlIndicatorColor" -> {
            } //color
            "ntlIndicatorColors" -> {
            } //reference
            "ntlIndicatorHeight" -> {
            } //dimension
            "ntlIndicatorCornerRadius" -> {
            } //dimension
            "ntlIndicatorPaddingTop" -> {
            } //dimension
            "ntlIndicatorPaddingBottom" -> {
            } //dimension
            "ntlDefaultTabColor" -> {
            } //color
            "ntlDefaultTabColors" -> {
            } //reference
            "ntlSelectedTabColor" -> {
            } //color
            "ntlSelectedTabColors" -> {
            } //reference
            "ntlTabPadding" -> {
            } //dimension
            "ntlTabPaddingTop" -> {
            } //dimension
            "ntlTabPaddingBottom" -> {
            } //dimension
            "ntlTabPaddingLeft" -> {
            } //dimension
            "ntlTabPaddingRight" -> {
            } //dimension
            "ntlTabViewLayoutId" -> {
            } //reference
            "ntlTabViewTextOrImageViewId" -> {
            } //reference
            "ntlDrawablePadding" -> {
            } //dimension
            "ntlTextSize" -> {
            } //dimension
            "ntlTextAllCaps" -> {
            } //boolean：0=true， 1=false
            "ntlTextStyle" -> {
            } //enum:0=normal,1=bold,2=italic,3=boldItalic
            "ntlIconCrossFade" -> {
            } //boolean：0=true， 1=false
            "ntlIconTint" -> {
            } //boolean：0=true， 1=false
            "ntlBlurRadius" -> {
            } //integer
            "ntlDownSampleFactor" -> {
            } //integer
            "ntlOverlayColor" -> {
            } //color
            "ntlBadgeGravity" -> {
            } //enum:0=left,1=center_left,2=center_right,3=right
            "ntlBadgeTextColor" -> {
            } //color
            "ntlBadgeTextSize" -> {
            } //dimension
            "ntlBadgeHeight" -> {
            } //dimension
            "ntlBadgeCornerRadius" -> {
            } //dimension
            "ntlBadgeMinWidth" -> {
            } //dimension
            "ntlBadgeMaxWidth" -> {
            } //dimension
            "ntlBadgeMarginLeft" -> {
            } //dimension
            "ntlBadgeMarginRight" -> {
            } //dimension
            "ntlBadgeMarginTop" -> {
            } //dimension
            "ntlBadgePaddingLeftRight" -> {
            } //dimension
            "ntlBadgeSmallSize" -> {
            } //dimension
            "ntlBadgeBackground" -> {
            } //reference|color
            else -> {
                ErrorStringTools.showString("NavigationAdapter 的类型值错误！")
            }
        }
    }

}