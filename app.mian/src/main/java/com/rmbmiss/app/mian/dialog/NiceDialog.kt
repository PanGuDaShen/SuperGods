package com.rmbmiss.app.mian.dialog

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.adapter.NiceAdapter
import com.rmbmiss.app.mian.base.BaseHFAbstartViewHolder
import com.rmbmiss.app.mian.databean.NavigationDatabean
import com.rmbmiss.app.mian.databean.NavigationList
import com.rmbmiss.lib.utils.dialog.BaseDialogFragment
import com.rmbmiss.lib.utils.errortools.ErrorStringTools
import com.rmbmiss.lib.utils.viewtools.RecyclerViewTools
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

    private var mContent: Context? = null

    fun setContent(content: Context?): NiceDialog {
        mContent = content
        return this
    }

    private var niceAdapter: NiceAdapter<NavigationDatabean, BaseHFAbstartViewHolder<NavigationDatabean>>?=null

    override fun getLayoutRes(): Int {
        return R.layout.dialog_nice
    }

    override fun bindView(v: View) {
        id_main_rv_2
    }

    override fun bindEvent() {

    }

    override fun bindData() {
        if (mContent == null) {
            ErrorStringTools.showString("NiceDialog的 mContent 变量没有赋值")
        } else {
            niceAdapter = NiceAdapter(mContent!!, NavigationList.list)
            id_main_rv_2?.let {
                RecyclerViewTools.setRvLinear(mContent!!, it, LinearLayoutManager.VERTICAL).adapter = niceAdapter
            }

//        niceAdapter?.setNiceTabLayout(id_main_ntl_2)
        }
    }
}