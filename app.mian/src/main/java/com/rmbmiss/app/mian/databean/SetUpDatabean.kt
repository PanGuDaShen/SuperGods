package com.rmbmiss.app.mian.databean

import android.app.Activity
import com.rmbmiss.app.mian.base.BaseActivity
import com.rmbmiss.app.mian.base.BaseDatabean

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/21$ 11:53$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/21$ 11:53$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
data class SetUpDatabean(var type: Int,var title:CharSequence, var map: MutableMap<CharSequence,Class<*>>): BaseDatabean() {

}