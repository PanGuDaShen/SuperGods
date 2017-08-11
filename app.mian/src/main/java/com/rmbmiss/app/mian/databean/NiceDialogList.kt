package com.rmbmiss.app.mian.databean

import com.rmbmiss.app.mian.base.BaseDatabean

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
object NiceDialogList {

    /**
     * 全部属性
     */
    fun getList(): MutableList<NicedialogDatabean> {
        var list = mutableListOf<NicedialogDatabean>(
                NicedialogDatabean("setDrawOrder","0"),
                NicedialogDatabean("setShowUnderline","false"),
                NicedialogDatabean("setShowDivider","false"),
                NicedialogDatabean("setShowIndicator","false"),
                NicedialogDatabean("setDistributeEvenly","false"),
                NicedialogDatabean("setTabSelectedCenter","false"),
                NicedialogDatabean("clearBadge","false"),
                NicedialogDatabean("setTabMode","0"),
                NicedialogDatabean("setTabColorBlendMode","0")
        )
        return list
    }

    data class NicedialogDatabean(var key:String,var veluce: String) :BaseDatabean(){

    }
}