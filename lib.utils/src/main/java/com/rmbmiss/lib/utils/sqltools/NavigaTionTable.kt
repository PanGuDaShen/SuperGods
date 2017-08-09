package com.rmbmiss.lib.utils.sqltools

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/25$ 11:00$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/25$ 11:00$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
object NavigaTionTable {
    //创建一张菜单设置默认属性naviga_tion表
    val naviga = "create table naviga(" +
     "_id integer primary key autoincrement," + // _id唯一键自动增长
     "ntlTabDistributeEvenly text," + // 布尔值：0=true， 1=false
     "ntlDrawOrder text," + //整型：0.1.2.3.4.5 有对应的attr.xml参照《name=NiceTabLayout》
     "ntlTabMode text," +  //整型：0=titleOnly,1=iconOnly,2=both
     "ntlTabColorBlendMode text," +  //整型：0=none,1=defaultSelected,2=nextSelected
     "ntlTabBackground text," +   //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlTabOffset text," + //浮点型：长度单位sp，px，dp......
     "ntlTabSelectedCenter text," + // 布尔值：0=true， 1=false
     "ntlShowUnderline text," +     // 布尔值：0=true， 1=false
     "ntlUnderlineInFront text," + // 布尔值：0=true， 1=false
     "ntlUnderlineGravity text," + //整型：0 = top ,1 = bottom
     "ntlUnderlineColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlUnderlineHeight text," + //浮点型：长度单位sp，px，dp......
     "ntlUnderlinePaddingTop text," + //浮点型：长度单位sp，px，dp......
     "ntlUnderlinePaddingBottom text," + //浮点型：长度单位sp，px，dp......
     "ntlShowDivider text," + // 布尔值：0=true， 1=false
     "ntlDividerColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlDividerColors text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlDividerWidth text," + //浮点型：长度单位sp，px，dp......
     "ntlDividerPadding text," + //浮点型：长度单位sp，px，dp......
     "ntlDividerPaddingTop text," + //浮点型：长度单位sp，px，dp......
     "ntlDividerPaddingBottom text," + //浮点型：长度单位sp，px，dp......
     "ntlDividerPaddingLeft text," + //浮点型：长度单位sp，px，dp......
     "ntlDividerPaddingRight text," + //浮点型：长度单位sp，px，dp......
     "ntlShowIndicator text," +  // 布尔值：0=true， 1=false
     "ntlIndicatorGravity text," + //整数：0=top，1=center，2=bottom
     "ntlIndicatorColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlIndicatorColors text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlIndicatorHeight text," + //浮点型：长度单位sp，px，dp......
     "ntlIndicatorCornerRadius text," + //浮点型：长度单位sp，px，dp......
     "ntlIndicatorPaddingTop text," + //浮点型：长度单位sp，px，dp......
     "ntlIndicatorPaddingBottom text," + //浮点型：长度单位sp，px，dp......
     "ntlDefaultTabColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlDefaultTabColors text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlSelectedTabColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlSelectedTabColors text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlTabPadding text," + //浮点型：长度单位sp，px，dp......
     "ntlTabPaddingTop text," + //浮点型：长度单位sp，px，dp......
     "ntlTabPaddingBottom text," + //浮点型：长度单位sp，px，dp......
     "ntlTabPaddingLeft text," + //浮点型：长度单位sp，px，dp......
     "ntlTabPaddingRight text," + //浮点型：长度单位sp，px，dp......
     "ntlTabViewLayoutId text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlTabViewTextOrImageViewId text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlDrawablePadding text," + //浮点型：长度单位sp，px，dp......
     "ntlTextSize text," + //浮点型：长度单位sp，px，dp......
     "ntlTextAllCaps text," + // 布尔值：0=true， 1=false
     "ntlTextStyle text," +  //整型：0=normal，1=bold，2=italic，3=boldItalic
     "ntlIconCrossFade text," + // 布尔值：0=true， 1=false
     "ntlIconTint text," + // 布尔值：0=true， 1=false
     "ntlBlurRadius text," +  //整型：
     "ntlDownSampleFactor text," +  //整型：
     "ntlOverlayColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlBadgeGravity text," +  //整型：0=left，1=center_left，2=center_right，3=right
     "ntlBadgeTextColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
     "ntlBadgeTextSize text," + //浮点型：长度单位sp，px，dp......
     "ntlBadgeHeight text," + //浮点型：长度单位sp，px，dp......
     "ntlBadgeCornerRadius text," + //浮点型：长度单位sp，px，dp......
     "ntlBadgeMinWidth text," + //浮点型：长度单位sp，px，dp......
     "ntlBadgeMaxWidth text," + //浮点型：长度单位sp，px，dp......
     "ntlBadgeMarginLeft text," + //浮点型：长度单位sp，px，dp......
     "ntlBadgeMarginRight text," + //浮点型：长度单位sp，px，dp......
     "ntlBadgeMarginTop text," + //浮点型：长度单位sp，px，dp......
     "ntlBadgePaddingLeftRight text," + //浮点型：长度单位sp，px，dp......
     "ntlBadgeSmallSize text," + //浮点型：长度单位sp，px，dp......
     "ntlBadgeBackground text" + //文本/颜色资源id："#00000000"/R.color.xxxx
     ")" // 布尔值：0=true， 1=false


    val insertNaviga = "insert into naviga("+
    "ntlTabDistributeEvenly,"+
    "ntlDrawOrder,"+
    "ntlTabMode,"+
    "ntlTabColorBlendMode,"+
    "ntlTabBackground,"+
    "ntlTabOffset,"+
    "ntlTabSelectedCenter,"+
    "ntlShowUnderline,"+
    "ntlUnderlineInFront,"+
    "ntlUnderlineGravity,"+
    "ntlUnderlineColor,"+
    "ntlUnderlineHeight,"+
    "ntlUnderlinePaddingTop,"+
    "ntlUnderlinePaddingBottom,"+
    "ntlShowDivider,"+
    "ntlDividerColor,"+
    "ntlDividerColors,"+
    "ntlDividerWidth,"+
    "ntlDividerPadding,"+
    "ntlDividerPaddingTop,"+
    "ntlDividerPaddingBottom,"+
    "ntlDividerPaddingLeft,"+
    "ntlDividerPaddingRight,"+
    "ntlShowIndicator,"+
    "ntlIndicatorGravity,"+
    "ntlIndicatorColor,"+
    "ntlIndicatorColors,"+
    "ntlIndicatorHeight,"+
    "ntlIndicatorCornerRadius,"+
    "ntlIndicatorPaddingTop,"+
    "ntlIndicatorPaddingBottom,"+
    "ntlDefaultTabColor,"+
    "ntlDefaultTabColors,"+
    "ntlSelectedTabColor,"+
    "ntlSelectedTabColors,"+
    "ntlTabPadding,"+
    "ntlTabPaddingTop,"+
    "ntlTabPaddingBottom,"+
    "ntlTabPaddingLeft,"+
    "ntlTabPaddingRight,"+
    "ntlTabViewLayoutId,"+
    "ntlTabViewTextOrImageViewId,"+
    "ntlDrawablePadding,"+
    "ntlTextSize,"+
    "ntlTextAllCaps,"+
    "ntlTextStyle,"+
    "ntlIconCrossFade,"+
    "ntlIconTint,"+
    "ntlBlurRadius,"+
    "ntlDownSampleFactor,"+
    "ntlOverlayColor,"+
    "ntlBadgeGravity,"+
    "ntlBadgeTextColor,"+
    "ntlBadgeTextSize,"+
    "ntlBadgeHeight,"+
    "ntlBadgeCornerRadius,"+
    "ntlBadgeMinWidth,"+
    "ntlBadgeMaxWidth,"+
    "ntlBadgeMarginLeft,"+
    "ntlBadgeMarginRight,"+
    "ntlBadgeMarginTop,"+
    "ntlBadgePaddingLeftRight,"+
    "ntlBadgeSmallSize,"+
    "ntlBadgeBackground"+
    ")"+
    "values"+
     "("+
            "1,"+
            "0,"+
            "0,"+   //ntlTabMode = 0 (0,1,2)
            "0,"+   //ntlTabColorBlendMode = 1 (0,1,2)
            "0,"+   //ntlTabBackground = -1
            "0,"+   //ntlTabOffset = (int) (24*getResources().getDisplayMetrics().density)
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0,"+
            "0"+
    ")"
            
            
    
    
}