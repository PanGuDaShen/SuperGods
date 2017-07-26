package com.rmbmiss.app.mian.databean

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：菜单栏属性集合
 * 创 建 人：IMissYou
 * 创建时间：2017/7/26 16:25
 * 修 改 人：IMissYou
 * 修改时间：2017/7/26 16:25
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
object NavigationList {

    /**
     * 全部属性
     */
    var list = mutableListOf<NavigationDatabean>(
            NavigationDatabean("ntlTabDistributeEvenly", 0), //boolean：0=true， 1=false
            NavigationDatabean("ntlDrawOrder", 0), //enum:0=indicatorUnderlineDivider,1=indicatorDividerUnderline,
            // 2=underlineIndicatorDivider,3=underlineDividerIndicator,4=dividerIndicatorUnderline,5=dividerUnderlineIndicator
            NavigationDatabean("ntlTabMode", 0), //enum：0=titleOnly，1=iconOnly，2=both
            NavigationDatabean("ntlTabColorBlendMode", 0), //enum：0=none，1=defaultSelected，2=nextSelected
            NavigationDatabean("ntlTabBackground", 0), //reference|color
            NavigationDatabean("ntlTabOffset", 0), //dimension
            NavigationDatabean("ntlTabSelectedCenter", 0), //boolean：0=true， 1=false
            NavigationDatabean("ntlShowUnderline", 0), //boolean：0=true， 1=false
            NavigationDatabean("ntlUnderlineInFront", 0), //boolean：0=true， 1=false
            NavigationDatabean("ntlUnderlineGravity", 0), //enum：0=top， 1=bottom
            NavigationDatabean("ntlUnderlineColor", 0), //color
            NavigationDatabean("ntlUnderlineHeight", 0), //dimension
            NavigationDatabean("ntlUnderlinePaddingTop", 0), //dimension
            NavigationDatabean("ntlUnderlinePaddingBottom", 0), //dimension
            NavigationDatabean("ntlShowDivider", 0), //boolean：0=true， 1=false
            NavigationDatabean("ntlDividerColor", 0), //color
            NavigationDatabean("ntlDividerColors", 0), //reference
            NavigationDatabean("ntlDividerWidth", 0), //dimension
            NavigationDatabean("ntlDividerPadding", 0), //dimension
            NavigationDatabean("ntlDividerPaddingTop", 0), //dimension
            NavigationDatabean("ntlDividerPaddingBottom", 0), //dimension
            NavigationDatabean("ntlDividerPaddingLeft", 0), //dimension
            NavigationDatabean("ntlDividerPaddingRight", 0), //dimension
            NavigationDatabean("ntlShowIndicator", 0), //boolean：0=true， 1=false
            NavigationDatabean("ntlIndicatorGravity", 0), //enum:0=top,1=center,2=bottom
            NavigationDatabean("ntlIndicatorColor", 0), //color
            NavigationDatabean("ntlIndicatorColors", 0), //reference
            NavigationDatabean("ntlIndicatorHeight", 0), //dimension
            NavigationDatabean("ntlIndicatorCornerRadius", 0), //dimension
            NavigationDatabean("ntlIndicatorPaddingTop", 0), //dimension
            NavigationDatabean("ntlIndicatorPaddingBottom", 0), //dimension
            NavigationDatabean("ntlDefaultTabColor", 0), //color
            NavigationDatabean("ntlDefaultTabColors", 0), //reference
            NavigationDatabean("ntlSelectedTabColor", 0), //color
            NavigationDatabean("ntlSelectedTabColors", 0), //reference
            NavigationDatabean("ntlTabPadding", 0), //dimension
            NavigationDatabean("ntlTabPaddingTop", 0), //dimension
            NavigationDatabean("ntlTabPaddingBottom", 0), //dimension
            NavigationDatabean("ntlTabPaddingLeft", 0), //dimension
            NavigationDatabean("ntlTabPaddingRight", 0), //dimension
            NavigationDatabean("ntlTabViewLayoutId", 0), //reference
            NavigationDatabean("ntlTabViewTextOrImageViewId", 0), //reference
            NavigationDatabean("ntlDrawablePadding", 0), //dimension
            NavigationDatabean("ntlTextSize", 0), //dimension
            NavigationDatabean("ntlTextAllCaps", 0), //boolean：0=true， 1=false
            NavigationDatabean("ntlTextStyle", 0), //enum:0=normal,1=bold,2=italic,3=boldItalic
            NavigationDatabean("ntlIconCrossFade", 0), //boolean：0=true， 1=false
            NavigationDatabean("ntlIconTint", 0), //boolean：0=true， 1=false
            NavigationDatabean("ntlBlurRadius", 0), //integer
            NavigationDatabean("ntlDownSampleFactor", 0), //integer
            NavigationDatabean("ntlOverlayColor", 0), //color
            NavigationDatabean("ntlBadgeGravity", 0), //enum:0=left,1=center_left,2=center_right,3=right
            NavigationDatabean("ntlBadgeTextColor", 0), //color
            NavigationDatabean("ntlBadgeTextSize", 0), //dimension
            NavigationDatabean("ntlBadgeHeight", 0), //dimension
            NavigationDatabean("ntlBadgeCornerRadius", 0), //dimension
            NavigationDatabean("ntlBadgeMinWidth", 0), //dimension
            NavigationDatabean("ntlBadgeMaxWidth", 0), //dimension
            NavigationDatabean("ntlBadgeMarginLeft", 0), //dimension
            NavigationDatabean("ntlBadgeMarginRight", 0), //dimension
            NavigationDatabean("ntlBadgeMarginTop", 0), //dimension
            NavigationDatabean("ntlBadgePaddingLeftRight", 0), //dimension
            NavigationDatabean("ntlBadgeSmallSize", 0), //dimension
            NavigationDatabean("ntlBadgeBackground", 0)  //reference|color
    )

}