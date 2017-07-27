package com.rmbmiss.app.mian.hodler

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.activity.SetUpActivity
import com.rmbmiss.app.mian.base.BaseHFAbstartViewHolder
import com.rmbmiss.app.mian.databean.SetUpDatabean
import com.rmbmiss.lib.utils.apptools.AppManagerUtils

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/21$ 11:38$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/21$ 11:38$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class SetUpHolder<T>(content:Context , view:View): BaseHFAbstartViewHolder<T>(view) {

    private var id_main_tv_1:TextView
    private var id_main_iv_1:ImageView
    private var id_main_tv_2:TextView

    private var num = 0

    init {
        mContext = content
        id_main_tv_1 = view.findViewById(R.id.id_main_tv_1)
        id_main_iv_1 = view.findViewById(R.id.id_main_iv_1)
        id_main_tv_2 = view.findViewById(R.id.id_main_tv_2)
    }

    override fun bindHolder(person: T) {
        person as SetUpDatabean
        id_main_tv_1.text = person.title
        person.map.forEach {
            when(num){
                0 -> {
                    id_main_tv_2.text = it.key
                    val value = it.value
                    id_main_tv_2.setOnClickListener {
                        mContext?.let {
                            it.startActivity(Intent(mContext,value))
                            AppManagerUtils.getInstance().finishActivity(SetUpActivity::class.java)
                        }
                    }
                }
                1 -> {
                    //以后有多余的就往这里添加
                }
            }
        }
    }
}