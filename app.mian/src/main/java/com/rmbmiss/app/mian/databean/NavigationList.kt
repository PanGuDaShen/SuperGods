package com.rmbmiss.app.mian.databean

/**
 * Created by Administrator on 2017/7/25.
 */
object NavigationList {

    /**
     * 全部属性
     */
    var list = mutableListOf<NavigationDatabean<String, Any?>>(
            NavigationDatabean<String, Any?>("ntlTabDistributeEvenly", 0), //boolean：0=true， 1=false
            NavigationDatabean<String, Any?>("ntlDrawOrder", 0), //enum:0=indicatorUnderlineDivider,1=indicatorDividerUnderline,
            // 2=underlineIndicatorDivider,3=underlineDividerIndicator,4=dividerIndicatorUnderline,5=dividerUnderlineIndicator
            NavigationDatabean<String, Any?>("ntlTabMode", 0), //enum：0=titleOnly，1=iconOnly，2=both
            NavigationDatabean<String, Any?>("ntlTabColorBlendMode", 0), //enum：0=none，1=defaultSelected，2=nextSelected
            NavigationDatabean<String, Any?>("ntlTabBackground", 0), //reference|color
            NavigationDatabean<String, Any?>("ntlTabOffset", 0), //dimension
            NavigationDatabean<String, Any?>("ntlTabSelectedCenter", 0), //boolean：0=true， 1=false
            NavigationDatabean<String, Any?>("ntlShowUnderline", 0), //boolean：0=true， 1=false
            NavigationDatabean<String, Any?>("ntlUnderlineInFront", 0), //boolean：0=true， 1=false
            NavigationDatabean<String, Any?>("ntlUnderlineGravity", 0), //enum：0=top， 1=bottom
            NavigationDatabean<String, Any?>("ntlUnderlineColor", 0), //color
            NavigationDatabean<String, Any?>("ntlUnderlineHeight", 0), //dimension
            NavigationDatabean<String, Any?>("ntlUnderlinePaddingTop", 0), //dimension
            NavigationDatabean<String, Any?>("ntlUnderlinePaddingBottom", 0), //dimension
            NavigationDatabean<String, Any?>("ntlShowDivider", 0), //boolean：0=true， 1=false
            NavigationDatabean<String, Any?>("ntlDividerColor", 0), //color
            NavigationDatabean<String, Any?>("ntlDividerColors", 0), //reference
            NavigationDatabean<String, Any?>("ntlDividerWidth", 0), //dimension
            NavigationDatabean<String, Any?>("ntlDividerPadding", 0), //dimension
            NavigationDatabean<String, Any?>("ntlDividerPaddingTop", 0), //dimension
            NavigationDatabean<String, Any?>("ntlDividerPaddingBottom", 0), //dimension
            NavigationDatabean<String, Any?>("ntlDividerPaddingLeft", 0), //dimension
            NavigationDatabean<String, Any?>("ntlDividerPaddingRight", 0), //dimension
            NavigationDatabean<String, Any?>("ntlShowIndicator", 0), //boolean：0=true， 1=false
            NavigationDatabean<String, Any?>("ntlIndicatorGravity", 0), //enum:0=top,1=center,2=bottom
            NavigationDatabean<String, Any?>("ntlIndicatorColor", 0), //color
            NavigationDatabean<String, Any?>("ntlIndicatorColors", 0), //reference
            NavigationDatabean<String, Any?>("ntlIndicatorHeight", 0), //dimension
            NavigationDatabean<String, Any?>("ntlIndicatorCornerRadius", 0), //dimension
            NavigationDatabean<String, Any?>("ntlIndicatorPaddingTop", 0), //dimension
            NavigationDatabean<String, Any?>("ntlIndicatorPaddingBottom", 0), //dimension
            NavigationDatabean<String, Any?>("ntlDefaultTabColor", 0), //color
            NavigationDatabean<String, Any?>("ntlDefaultTabColors", 0), //reference
            NavigationDatabean<String, Any?>("ntlSelectedTabColor", 0), //color
            NavigationDatabean<String, Any?>("ntlSelectedTabColors", 0), //reference
            NavigationDatabean<String, Any?>("ntlTabPadding", 0), //dimension
            NavigationDatabean<String, Any?>("ntlTabPaddingTop", 0), //dimension
            NavigationDatabean<String, Any?>("ntlTabPaddingBottom", 0), //dimension
            NavigationDatabean<String, Any?>("ntlTabPaddingLeft", 0), //dimension
            NavigationDatabean<String, Any?>("ntlTabPaddingRight", 0), //dimension
            NavigationDatabean<String, Any?>("ntlTabViewLayoutId", 0), //reference
            NavigationDatabean<String, Any?>("ntlTabViewTextOrImageViewId", 0), //reference
            NavigationDatabean<String, Any?>("ntlDrawablePadding", 0), //dimension
            NavigationDatabean<String, Any?>("ntlTextSize", 0), //dimension
            NavigationDatabean<String, Any?>("ntlTextAllCaps", 0), //boolean：0=true， 1=false
            NavigationDatabean<String, Any?>("ntlTextStyle", 0), //enum:0=normal,1=bold,2=italic,3=boldItalic
            NavigationDatabean<String, Any?>("ntlIconCrossFade", 0), //boolean：0=true， 1=false
            NavigationDatabean<String, Any?>("ntlIconTint", 0), //boolean：0=true， 1=false
            NavigationDatabean<String, Any?>("ntlBlurRadius", 0), //integer
            NavigationDatabean<String, Any?>("ntlDownSampleFactor", 0), //integer
            NavigationDatabean<String, Any?>("ntlOverlayColor", 0), //color
            NavigationDatabean<String, Any?>("ntlBadgeGravity", 0), //enum:0=left,1=center_left,2=center_right,3=right
            NavigationDatabean<String, Any?>("ntlBadgeTextColor", 0), //color
            NavigationDatabean<String, Any?>("ntlBadgeTextSize", 0), //dimension
            NavigationDatabean<String, Any?>("ntlBadgeHeight", 0), //dimension
            NavigationDatabean<String, Any?>("ntlBadgeCornerRadius", 0), //dimension
            NavigationDatabean<String, Any?>("ntlBadgeMinWidth", 0), //dimension
            NavigationDatabean<String, Any?>("ntlBadgeMaxWidth", 0), //dimension
            NavigationDatabean<String, Any?>("ntlBadgeMarginLeft", 0), //dimension
            NavigationDatabean<String, Any?>("ntlBadgeMarginRight", 0), //dimension
            NavigationDatabean<String, Any?>("ntlBadgeMarginTop", 0), //dimension
            NavigationDatabean<String, Any?>("ntlBadgePaddingLeftRight", 0), //dimension
            NavigationDatabean<String, Any?>("ntlBadgeSmallSize", 0), //dimension
            NavigationDatabean<String, Any?>("ntlBadgeBackground", 0)  //reference|color
    )

}