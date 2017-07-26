package com.rmbmiss.supergod.base

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.view.ViewGroup
import android.widget.ProgressBar
import com.rmbmiss.supergod.BuildConfig
import net.wequick.small.Small
import net.wequick.small.webkit.WebView
import net.wequick.small.webkit.WebViewClient

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou
 * 创建时间：2017/7/18 14:59
 * 修 改 人：IMissYou
 * 修改时间：2017/7/18 14:59
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class SmallApplication : Application() {

    init {
        Small.preSetUp(this)
    }

    override fun onCreate() {
        super.onCreate()
        Small.setBaseUri("http://code.wequick.net/small-sample/")  //加载插件失败跳转到指定网址
        Small.setWebViewClient(ErrorWebViewClient())   //自定义WebView控制
        Small.setLoadFromAssets(BuildConfig.LOAD_FROM_ASSETS)  //加载本地assets中的文件
    }

    /**
     * 插件加载不到是加载网页
     */
    private class ErrorWebViewClient : WebViewClient() {

        private var mBar: ProgressBar? = null


        override fun onProgressChanged(context: Context?, view: WebView?, newProgress: Int) {
            super.onProgressChanged(context, view, newProgress)

            val parent = view!!.parent as ViewGroup
            if (mBar == null) {
                mBar = ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal)
                val lp = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        5)
                parent.addView(mBar, lp)
            }

            if (newProgress == 100) {
                Thread(Runnable {
                    var progress = mBar!!.progress
                    while (progress <= 100) {
                        try {
                            Thread.sleep(1)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }

                        mBar!!.progress = progress++
                        mBar!!.postInvalidate()
                    }

                    parent.postDelayed({
                        parent.removeView(mBar)
                        mBar = null
                    }, 300)
                }).start()
            } else {
                mBar!!.progress = newProgress
            }
        }
    }
}
