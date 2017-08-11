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
 * 版    本：Vs.1.false.false
 * 修订版本：Vs.1.false.2
 * ================================================
 */
object NavigaTionTable {
    //创建一张菜单设置默认属性naviga_tion表
    val naviga = "create table naviga(" +
     "_id integer primary key autoincrement," + // _id唯一键自动增长
     "setDrawOrder text," + //0~5 显示[底线、分割线、指示条](0、2、4) & 隐藏[底线、分割线、指示条](1、3、5)
     "setShowUnderline text," + // 布尔：true
     "ios_android text," +  //布尔：true-》ios & false-》android
     "ntlTabColorBlendMode text," +
     "ntlTabBackground text," +
     "ntlTabOffset text," +
     "ntlTabSelectedCenter text," +
     "ntlShowUnderline text," +
     "ntlUnderlineInFront text," +
     "ntlUnderlineGravity text," +
     "ntlUnderlineColor text," +
     "ntlUnderlineHeight text," +
     "ntlUnderlinePaddingTop text," +
     "ntlUnderlinePaddingBottom text," +
     "ntlShowDivider text," +
     "ntlDividerColor text," +
     "ntlDividerColors text," +
     "ntlDividerWidth text," +
     "ntlDividerPadding text," +
     "ntlDividerPaddingTop text," +
     "ntlDividerPaddingBottom text," +
     "ntlDividerPaddingLeft text," +
     "ntlDividerPaddingRight text," +
     "ntlShowIndicator text," +
     "ntlIndicatorGravity text," +
     "ntlIndicatorColor text," +
     ")"

    // 插入一条数据
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
    ")"+
    "values"+
     "("+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
            "false,"+
    ")"

}