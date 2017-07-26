package com.rmbmiss.lib.utils.lnstancetools

import com.rmbmiss.lib.utils.errortools.ErrorStringTools
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：委托类
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/18$ 17:14$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/18$ 17:14$
 * 修改备注：由于使用了异常处理机制，所以调用的时候放在静态代码块中调用。
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class OutClassObject<T>:ReadWriteProperty<Any?,T> {
    // 定义一个可变变量保存委托值
    private var classValue:T? = null

    /**
     * 设置委托值
     * @param thisRef
     * @param property
     * @param value 委托传入的类对象值
     */
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if(classValue==null){
            classValue = value
        }
    }

    /**
     * 获取返回委托值，如果委托值=null，则抛出异常
     */
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return classValue as T
    }
}