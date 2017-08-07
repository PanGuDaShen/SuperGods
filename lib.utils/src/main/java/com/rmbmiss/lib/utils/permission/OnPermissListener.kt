package com.rmbmiss.lib.utils.permission

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/8/7$ 16:21$
 * 修 改 人：IMissYou$
 * 修改时间：2017/8/7$ 16:21$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
interface OnPermissListener {
    fun onSourse()   //已经授权
    fun onRationale(code: Int, ra: MutableSet<String>)   //未授权切勾选不在询问
    fun onNoRequce(code: Int, no: MutableSet<String>) //未授权切没有勾选不在询问
}