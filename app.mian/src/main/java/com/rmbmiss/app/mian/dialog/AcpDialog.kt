package com.rmbmiss.app.mian.dialog

import android.os.Bundle
import android.view.View
import com.rmbmiss.app.mian.R
import com.rmbmiss.lib.utils.dialog.BaseDialogFragment
import kotlinx.android.synthetic.main.dialog_acp.*

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/8/3$ 10:58$
 * 修 改 人：IMissYou$
 * 修改时间：2017/8/3$ 10:58$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class AcpDialog: BaseDialogFragment(),View.OnClickListener{

    private var click:OnAcpDialoglister?=null

    companion object {
        fun newAcpDialog(savedInstanceState: Bundle?):AcpDialog{
            val acpDialog = AcpDialog()
            acpDialog.arguments = savedInstanceState
            return acpDialog
        }
    }

    override fun getLayoutRes(): Int {
        if (lat == -1){
            return R.layout.dialog_acp
        }
        return lat
    }

    override fun bindView(v: View) {
    }

    override fun bindEvent() {
        id_main_tv_13.setOnClickListener(this)
        id_main_tv_14.setOnClickListener(this)
    }

    override fun bindData() {
    }

    override fun onClick(p0: View?) {
        when(p0){
            id_main_tv_13 -> {
                click?.let { it.onClick("NO") }
                dismiss()
            }
            id_main_tv_14 -> {
                click?.let { it.onClick("YES") }
                dismiss()
            }
        }
    }

    fun setTitle(str:String):AcpDialog{
        id_main_tv_11.text = str
        return this
    }

    fun setData(str:String):AcpDialog{
        id_main_tv_12.text = str
        return this
    }

    fun setNo(str:String):AcpDialog{
        id_main_tv_13.text = str
        return this
    }

    fun setYes(str:String):AcpDialog{
        id_main_tv_14.text = str
        return this
    }
    fun setStyleAnimont(sm:Int):AcpDialog{
        styleAnimont = sm
        return this
    }
    /**
     * 添加事件
     */
    fun setOnAcpDialoglister(c:OnAcpDialoglister):AcpDialog{
        click = c
        return this
    }

    /**
     * 定义事件
     */
    interface OnAcpDialoglister{
        fun onClick(str:String)
    }

    override fun initBundle(savedInstanceState: Bundle?) {
       arguments?.let {
           lat = it.getInt("lat")
       }
    }
}