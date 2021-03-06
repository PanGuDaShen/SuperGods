package com.rmbmiss.app.mian.hodler

import android.content.Context
import android.view.View
import android.widget.CompoundButton
import android.widget.TextView
import com.kyleduo.switchbutton.SwitchButton
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.base.BaseHFAbstartViewHolder
import com.rmbmiss.app.mian.databean.NiceDialogList

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/8/9$ 16:52$
 * 修 改 人：IMissYou$
 * 修改时间：2017/8/9$ 16:52$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class NiceHodler<T>(content: Context?, view: View,listener:OnNiceClickListener?): BaseHFAbstartViewHolder<T>(view) {

    private var id_main_tv_3:TextView
    private var id_main_tv_4:TextView
    private var id_mian_sb1: SwitchButton
    private var mContent: Context? = null
    private var mListener:OnNiceClickListener? = null

    init {
        id_main_tv_3 = view.findViewById(R.id.id_main_tv_3)
        id_main_tv_4 = view.findViewById(R.id.id_main_tv_4)
        id_mian_sb1 = view.findViewById(R.id.id_mian_sb1)
        content?.let {
            mContent = content
            mListener = listener
        }
    }
    override fun bindHolder(person: T) {
        person as NiceDialogList.NicedialogDatabean
        id_main_tv_3.setText(person.key)
        when(person.key){
            "setDrawOrder" -> {
                id_mian_sb1.visibility = View.GONE
                when(person.veluce){
                    "0" -> {id_main_tv_4.text = person.veluce}
                    "1" -> {id_main_tv_4.text = person.veluce}
                    "2" -> {id_main_tv_4.text = person.veluce}
                    "3" -> {id_main_tv_4.text = person.veluce}
                    "4" -> {id_main_tv_4.text = person.veluce}
                    "5" -> {id_main_tv_4.text = person.veluce}
                }
            }
            "setShowUnderline" -> {
                id_main_tv_4.visibility = View.GONE
                when(person.veluce){
                    "true" -> id_mian_sb1.isChecked = true
                    "false" -> id_mian_sb1.isChecked = false
                    else -> id_mian_sb1.isChecked = false
                }
            }
            "setShowDivider" -> {
                id_main_tv_4.visibility = View.GONE
                when(person.veluce){
                    "true" -> id_mian_sb1.isChecked = true
                    "false" -> id_mian_sb1.isChecked = false
                    else -> id_mian_sb1.isChecked = false
                }
            }
            "setShowIndicator" -> {
                id_main_tv_4.visibility = View.GONE
                when(person.veluce){
                    "true" -> id_mian_sb1.isChecked = true
                    "false" -> id_mian_sb1.isChecked = false
                    else -> id_mian_sb1.isChecked = false
                }
            }
            "setDistributeEvenly" -> {
                id_main_tv_4.visibility = View.GONE
                when(person.veluce){
                    "true" -> id_mian_sb1.isChecked = true
                    "false" -> id_mian_sb1.isChecked = false
                    else -> id_mian_sb1.isChecked = false
                }
            }
            "setTabSelectedCenter" -> {
                id_main_tv_4.visibility = View.GONE
                when(person.veluce){
                    "true" -> id_mian_sb1.isChecked = true
                    "false" -> id_mian_sb1.isChecked = false
                    else -> id_mian_sb1.isChecked = false
                }
            }
            "clearBadge" -> {
                id_main_tv_4.visibility = View.GONE
                when(person.veluce){
                    "true" -> id_mian_sb1.isChecked = true
                    "false" -> id_mian_sb1.isChecked = false
                    else -> id_mian_sb1.isChecked = false
                }
            }
            "setTabMode" -> {
                id_mian_sb1.visibility = View.GONE
                when(person.veluce){
                    "0" -> {id_main_tv_4.text = person.veluce}
                    "1" -> {id_main_tv_4.text = person.veluce}
                    "2" -> {id_main_tv_4.text = person.veluce}
                }
            }
            "setTabColorBlendMode" -> {
                id_mian_sb1.visibility = View.GONE
                when(person.veluce){
                    "0" -> {id_main_tv_4.text = person.veluce}
                    "1" -> {id_main_tv_4.text = person.veluce}
                    "2" -> {id_main_tv_4.text = person.veluce}
                }
            }
        }
        id_mian_sb1.setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                mListener?.let {
                    if (p1)person.veluce = "true" else person.veluce = "false"
                    it.onClicks(person)
                }
            }
        })
    }

    fun setOnClickListener(listener:OnNiceClickListener?){
        this.mListener = listener
    }

    interface OnNiceClickListener{
        fun onClicks(str:NiceDialogList.NicedialogDatabean)
    }
}