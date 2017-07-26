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
    val stu_table = "create table naviga_tion(" +
            "id integer primary key autoincrement," + // id唯一键自动增长
            "ntlTabDistributeEvenly integer," + // 布尔值：0=true， 1=false
            "ntlDrawOrder integer," + //整型：0.1.2.3.4.5 有对应的attr.xml参照《name=NiceTabLayout》
            "ntlTabMode integer," +  //整型：0=titleOnly,1=iconOnly,2=both
            "ntlTabColorBlendMode integer," +  //整型：0=none,1=defaultSelected,2=nextSelected
            "ntlTabBackground text," +   //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlTabOffset float," + //浮点型：长度单位sp，px，dp......
            "ntlTabSelectedCenter integer," + // 布尔值：0=true， 1=false
            "ntlShowUnderline integer," +     // 布尔值：0=true， 1=false
            "ntlUnderlineInFront integer," + // 布尔值：0=true， 1=false
            "ntlUnderlineGravity integer," + //整型：0 = top ,1 = bottom
            "ntlUnderlineColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlUnderlineHeight float," + //浮点型：长度单位sp，px，dp......
            "ntlUnderlinePaddingTop float," + //浮点型：长度单位sp，px，dp......
            "ntlUnderlinePaddingBottom float," + //浮点型：长度单位sp，px，dp......
            "ntlShowDivider integer," + // 布尔值：0=true， 1=false
            "ntlDividerColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlDividerColors text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlDividerWidth float," + //浮点型：长度单位sp，px，dp......
            "ntlDividerPadding float," + //浮点型：长度单位sp，px，dp......
            "ntlDividerPaddingTop float," + //浮点型：长度单位sp，px，dp......
            "ntlDividerPaddingBottom float," + //浮点型：长度单位sp，px，dp......
            "ntlDividerPaddingLeft float," + //浮点型：长度单位sp，px，dp......
            "ntlDividerPaddingRight float," + //浮点型：长度单位sp，px，dp......
            "ntlShowIndicator integer," +  // 布尔值：0=true， 1=false
            "ntlIndicatorGravity integer," + //整数：0=top，1=center，2=bottom
            "ntlIndicatorColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlIndicatorColors text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlIndicatorHeight float," + //浮点型：长度单位sp，px，dp......
            "ntlIndicatorCornerRadius float," + //浮点型：长度单位sp，px，dp......
            "ntlIndicatorPaddingTop float," + //浮点型：长度单位sp，px，dp......
            "ntlIndicatorPaddingBottom float," + //浮点型：长度单位sp，px，dp......
            "ntlDefaultTabColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlDefaultTabColors text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlSelectedTabColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlSelectedTabColors text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlTabPadding float," + //浮点型：长度单位sp，px，dp......
            "ntlTabPaddingTop float," + //浮点型：长度单位sp，px，dp......
            "ntlTabPaddingBottom float," + //浮点型：长度单位sp，px，dp......
            "ntlTabPaddingLeft float," + //浮点型：长度单位sp，px，dp......
            "ntlTabPaddingRight float," + //浮点型：长度单位sp，px，dp......
            "ntlTabViewLayoutId text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlTabViewTextOrImageViewId text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlDrawablePadding float," + //浮点型：长度单位sp，px，dp......
            "ntlTextSize float," + //浮点型：长度单位sp，px，dp......
            "ntlTextAllCaps integer," + // 布尔值：0=true， 1=false
            "ntlTextStyle integer," +  //整型：0=normal，1=bold，2=italic，3=boldItalic
            "ntlIconCrossFade integer," + // 布尔值：0=true， 1=false
            "ntlIconTint integer," + // 布尔值：0=true， 1=false
            "ntlBlurRadius integer," +  //整型：
            "ntlDownSampleFactor integer," +  //整型：
            "ntlOverlayColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlBadgeGravity integer," +  //整型：0=left，1=center_left，2=center_right，3=right
            "ntlBadgeTextColor text," + //文本/颜色资源id："#00000000"/R.color.xxxx
            "ntlBadgeTextSize float," + //浮点型：长度单位sp，px，dp......
            "ntlBadgeHeight float," + //浮点型：长度单位sp，px，dp......
            "ntlBadgeCornerRadius float," + //浮点型：长度单位sp，px，dp......
            "ntlBadgeMinWidth float," + //浮点型：长度单位sp，px，dp......
            "ntlBadgeMaxWidth float," + //浮点型：长度单位sp，px，dp......
            "ntlBadgeMarginLeft float," + //浮点型：长度单位sp，px，dp......
            "ntlBadgeMarginRight float," + //浮点型：长度单位sp，px，dp......
            "ntlBadgeMarginTop float," + //浮点型：长度单位sp，px，dp......
            "ntlBadgePaddingLeftRight float," + //浮点型：长度单位sp，px，dp......
            "ntlBadgeSmallSize float," + //浮点型：长度单位sp，px，dp......
            "ntlBadgeBackground text" + //文本/颜色资源id："#00000000"/R.color.xxxx
            ")" // 布尔值：0=true， 1=false

}