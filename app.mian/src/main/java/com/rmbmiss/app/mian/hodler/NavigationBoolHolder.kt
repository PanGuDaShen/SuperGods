package com.rmbmiss.app.mian.hodler

import android.content.Context
import android.view.View
import com.rmbmiss.app.mian.base.BaseAbstartViewHolder
import com.rmbmiss.app.mian.databean.NavigationDatabean

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou
 * 创建时间：2017/7/26 16:43
 * 修 改 人：IMissYou
 * 修改时间：2017/7/26 16:43
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class NavigationBoolHolder<T>(content: Context, view: View): BaseAbstartViewHolder<T>(view) {
    override fun bindHolder(person: T) {
        person as NavigationDatabean
    }
}

