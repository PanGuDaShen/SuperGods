package com.rmbmiss.app.mian.dialog

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.blankj.utilcode.util.LogUtils
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.adapter.NiceAdapter
import com.rmbmiss.app.mian.base.BaseHFAbstartViewHolder
import com.rmbmiss.app.mian.databean.NiceDialogList
import com.rmbmiss.app.mian.hodler.NiceHodler
import com.rmbmiss.lib.utils.dialog.BaseDialogFragment
import com.rmbmiss.lib.utils.errortools.ErrorStringTools
import com.rmbmiss.lib.utils.viewtools.RecyclerViewTools
import com.rmbmiss.nicetablibrary.NiceTabLayout
import com.rmbmiss.nicetablibrary.NiceTabStrip
import kotlinx.android.synthetic.main.dialog_nice.*

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/8/9$ 16:46$
 * 修 改 人：IMissYou$
 * 修改时间：2017/8/9$ 16:46$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class NiceDialog: BaseDialogFragment() {

    private var tabLayout: NiceTabLayout? = null
    private var niceAdapter: NiceAdapter<NiceDialogList.NicedialogDatabean, BaseHFAbstartViewHolder<NiceDialogList.NicedialogDatabean>>?=null

    override fun getLayoutRes(): Int {
        return R.layout.dialog_nice
    }

    override fun bindView(v: View) {
        id_main_rv_2
    }

    override fun bindEvent() {
        niceAdapter?.setOnNiceClickListener(object :NiceHodler.OnNiceClickListener{
            override fun onClicks(str: NiceDialogList.NicedialogDatabean) {
                LogUtils.e("Key = ${str.key}   valuce = ${str.veluce}")
                tabLayout?.let {
                    when(str.key){
                         "setDrawOrder" -> {
                             when(str.veluce){
                                 "0" -> it.setDrawOrder(NiceTabStrip.DrawOrder.INDICATOR_UNDERLINE_DIVIDER)
                                 "1" -> it.setDrawOrder(NiceTabStrip.DrawOrder.INDICATOR_DIVIDER_UNDERLINE)
                                 "2" -> it.setDrawOrder(NiceTabStrip.DrawOrder.UNDERLINE_INDICATOR_DIVIDER)
                                 "3" -> it.setDrawOrder(NiceTabStrip.DrawOrder.UNDERLINE_DIVIDER_INDICATOR)
                                 "4" -> it.setDrawOrder(NiceTabStrip.DrawOrder.DIVIDER_INDICATOR_UNDERLINE)
                                 "5" -> it.setDrawOrder(NiceTabStrip.DrawOrder.DIVIDER_UNDERLINE_INDICATOR)
                                 else -> it.setDrawOrder(NiceTabStrip.DrawOrder.INDICATOR_UNDERLINE_DIVIDER)
                             }
                         }
                         "setShowUnderline" -> {
                             when(str.veluce){
                                 "true" -> it.setShowUnderline(true)
                                 else -> it.setShowUnderline(false)
                             }
                         }
                         "setShowDivider" -> {
                             when(str.veluce){
                                 "true" -> it.setShowDivider(true)
                                 else -> it.setShowDivider(false)
                             }
                         }
                         "setShowIndicator" -> {
                             when(str.veluce){
                                 "true" -> it.setShowIndicator(true)
                                 else -> it.setShowIndicator(false)
                             }
                         }
                         "setDistributeEvenly" -> {
                             when(str.veluce){
                                 "true" -> it.setDistributeEvenly(true)
                                 else -> it.setDistributeEvenly(false)
                             }
                         }
                         "setTabSelectedCenter" -> {
                             when(str.veluce){
                                 "true" -> it.setTabSelectedCenter(true)
                                 else -> it.setTabSelectedCenter(false)
                             }
                         }
                         "clearBadge" -> {
                             when(str.veluce){
                                 "true" -> it.clearBadge()
                                 else -> it.clearBadge()
                             }
                         }
                         "setTabMode" -> {
                             when(str.veluce){
                                 "0" -> it.setTabMode(NiceTabLayout.TabMode.TITLE_ONLY)
                                 "1" -> it.setTabMode(NiceTabLayout.TabMode.ICON_ONLY)
                                 "2" -> it.setTabMode(NiceTabLayout.TabMode.BOTH)
                                 else -> it.setTabMode(NiceTabLayout.TabMode.TITLE_ONLY)
                             }
                         }
                         "setTabColorBlendMode" -> {
                             when(str.veluce){
                                 "0" -> it.setTabColorBlendMode(NiceTabLayout.TabColorBlendMode.NONE)
                                 "1" -> it.setTabColorBlendMode(NiceTabLayout.TabColorBlendMode.DEFAULT_SELECTED)
                                 "2" -> it.setTabColorBlendMode(NiceTabLayout.TabColorBlendMode.NEXT_SELECTED)
                                 else -> it.setTabColorBlendMode(NiceTabLayout.TabColorBlendMode.NONE)
                             }
                         }
                    }
                }
            }
        })
    }

    override fun bindData() {
        if (context == null) {
            niceAdapter = NiceAdapter(context, NiceDialogList.getList())
            id_main_rv_2?.let {
                RecyclerViewTools.setRvLinear(context, it, LinearLayoutManager.VERTICAL).adapter = niceAdapter
            }
//        niceAdapter?.setNiceTabLayout(id_main_ntl_2)
        }
    }

    fun setNiceTabLayout(tabLayout: NiceTabLayout): NiceDialog {
        this.tabLayout = tabLayout
        return this
    }

}