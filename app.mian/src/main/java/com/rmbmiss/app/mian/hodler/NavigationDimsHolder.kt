package com.rmbmiss.app.mian.hodler

import android.content.Context
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.adapter.NavigationAdapter
import com.rmbmiss.app.mian.base.BaseHFAbstartViewHolder
import com.rmbmiss.app.mian.click.OnClickface
import com.rmbmiss.app.mian.databean.NavigationDatabean

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou
 * 创建时间：2017/7/26 16:41
 * 修 改 人：IMissYou
 * 修改时间：2017/7/26 16:41
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class NavigationDimsHolder<T>(content: Context, view: View): BaseHFAbstartViewHolder<T>(view) {

    private var onClickNavigaface: OnClickface? = null

    private var id_main_tv_9: TextView
    private var id_main_tv_10: TextView

    init {
        id_main_tv_9 = view.findViewById(R.id.id_main_tv_9)
        id_main_tv_10 = view.findViewById(R.id.id_main_tv_10)
    }

    override fun bindHolder(person: T) {
        person as NavigationDatabean
        id_main_tv_9.text = person.key
        id_main_tv_10.text= person.value.toString()
        id_main_tv_10.setOnClickListener {
            onClickNavigaface?.let {
                it.onClick(person)
            }
        }
    }

    /**
     * 添加监听事件
     */
    fun addOnClick(onClickNavigaface: OnClickface){
        this.onClickNavigaface = onClickNavigaface
    }
}
