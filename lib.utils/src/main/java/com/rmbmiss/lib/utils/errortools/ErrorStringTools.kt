package com.rmbmiss.lib.utils.errortools

import com.blankj.utilcode.util.LogUtils

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：自定义异常处理工具类
 * 创 建 人：IMissYou
 * 创建时间：2017/7/24 11:26
 * 修 改 人：IMissYou
 * 修改时间：2017/7/24 11:26
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
object ErrorStringTools {

    //错误异常是否抛出--》开关，在Apploaction中设置
    var showBool = true

    fun showString(error: String){
        if (showBool){
            LogUtils.e(error)
            throw IllegalStateException(error)
        }
    }
}