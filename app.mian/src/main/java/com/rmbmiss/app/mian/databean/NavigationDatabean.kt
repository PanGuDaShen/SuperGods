package com.rmbmiss.app.mian.databean

import com.rmbmiss.app.mian.base.BaseDatabean

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou
 * 创建时间：2017/7/26 16:26
 * 修 改 人：IMissYou
 * 修改时间：2017/7/26 16:26
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
data class NavigationDatabean<K,V>(var key:K,var value:V):BaseDatabean() {

}