package com.rmbmiss.supergod.activity

import android.Manifest
import android.os.Handler
import android.widget.Toast
import com.rmbmiss.supergod.R
import com.rmbmiss.supergod.base.BaseSuperActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import net.wequick.small.Small

class WelcomeActivity : BaseSuperActivity() {

    override fun setLayoutView(): Int {
        return R.layout.activity_welcome
    }

    override fun initEvent() {

    }

    override fun initData() {
        openUri("mian/av_mian", null)
    }

    /**
     * 跳转到指定插件页面
     * @param uri   插件标签(模块代号/模块子页面代号)
     * @param map   传递的参数集合
     */
    private fun openUri(uri: String, map: MutableMap<String, String>?) {
        var uriName = uri;
        map?.let {
            val sb = StringBuffer()
            sb.append(uri)
            for ((k,v) in map){
                sb.append("?")
                sb.append("$k")
                sb.append("=")
                sb.append("$v")
            }
            uriName = sb.toString()
        }
        Handler().postDelayed({
            //监听宿主中的插件加载是否完成。
            Small.setUp(this@WelcomeActivity) {
                Small.openUri(uriName, this@WelcomeActivity)    //跳转到指定插件页面
                finish()
            }
        }, 200000)

    }

}
