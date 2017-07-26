package com.rmbmiss.app.mian.fragment

import android.view.View
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_ins.*

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/19$ 17:19$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/19$ 17:19$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class InsFragment :BaseFragment() {

    companion object {
        var test = "wu"
        fun newInstance(str: CharSequence): InsFragment{
            test = str as String
            return InsFragment()
        }
    }
    override fun setLayout(): Int {
        return R.layout.fragment_ins
    }

    override fun setEvent() {

    }

    override fun setData() {
        id_mian_test.text = test
    }

    override fun processClick(v: View) {

    }
}