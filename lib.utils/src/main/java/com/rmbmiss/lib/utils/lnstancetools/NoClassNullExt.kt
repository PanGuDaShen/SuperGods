package com.rmbmiss.lib.utils.lnstancetools

import kotlin.properties.ReadWriteProperty

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：静态方法类，每个方法必须返回一个委托类.
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/18$ 17:09$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/18$ 17:09$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
object NoClassNullExt {

    /**
     * 通用获取单列对象
     */
    fun<T> noNullClassObject():ReadWriteProperty<Any?,T>{
        return OutClassObject<T>()
    }
}