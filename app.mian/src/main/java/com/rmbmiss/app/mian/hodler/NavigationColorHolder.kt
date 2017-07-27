package com.rmbmiss.app.mian.hodler

import android.content.Context
import android.view.View
import android.widget.TextView
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.base.BaseHFAbstartViewHolder
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
class NavigationColorHolder<T>(content: Context, view: View): BaseHFAbstartViewHolder<T>(view) {

    private var id_main_tv_5: TextView
    private var id_main_tv_6:TextView

    init {
        id_main_tv_5 = view.findViewById(R.id.id_main_tv_5)
        id_main_tv_6 = view.findViewById(R.id.id_main_tv_6)
    }

    override fun bindHolder(person: T) {
        person as NavigationDatabean
        id_main_tv_5.text = person.key
    }
}

