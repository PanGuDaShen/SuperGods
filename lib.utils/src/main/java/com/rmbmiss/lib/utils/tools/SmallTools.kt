package com.rmbmiss.lib.utils.tools

import android.app.Activity
import android.content.Context
import com.rmbmiss.lib.utils.lnstancetools.NoClassNullExt
import net.wequick.small.Small

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：Small插件化辅助工具
 * 创 建 人：IMissYou
 * 创建时间：2017/7/18 16:52
 * 修 改 人：IMissYou
 * 修改时间：2017/7/18 16:52
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class SmallTools private constructor(){ // private constructor() 私有化构造函数
    /**
     * 主初始化函数（不带参数）
     */
    init {
        throw RuntimeException("不能创建SmallTools对象！")
    }

    /**
     * 静态代码快，代码块内的都是静态变量或静态函数（方法）
     */
    companion object {
        // 使用托管方法，意思就是事情丢给别人去做
        private var st: SmallTools by NoClassNullExt.noNullClassObject<SmallTools>()
        //获取单列对象
        fun getInstance(): SmallTools {
            return st
        }
    }

    /**
     * 跳转到指定插件的页面
     * @param uri 指定跳转的模块页面
     * @param map 键值对参数集合
     * @param content 上下文
     */
    fun openUriActivity(uri: String, map: MutableMap<String, String>?,content: Context){
        val sb = StringBuffer()
        map?.let {
            sb.append(uri)
            for ((k,v) in map){
                sb.append("?")
                sb.append("$k")
                sb.append("=")
                sb.append("$v")
            }
        }
        Small.openUri(sb.toString(),content)
    }

    /**
     * 获取跳转插件的传参list集合
     */
    fun getUriParameters(str: String,content: Activity): MutableList<String>? {
        val uri = Small.getUri(content)
        if (uri!=null){
            return uri.getQueryParameters(str)
        }
        return null
    }

    /**
     * 获取跳转插件的单个传参
     */
    fun getUriParameter(str: String,content: Activity): String? {
        val uri = Small.getUri(content)
        if (uri!=null){
            return uri.getQueryParameter(str)
        }
        return null
    }

    /**
     * 获取跳转插件的单个传参
     */
    fun getQueryParameter(str: String,content: Activity): String? {
        val uri = Small.getUri(content)
        if (uri!=null){
            return uri.getQueryParameter(str)
        }
        return null
    }
}