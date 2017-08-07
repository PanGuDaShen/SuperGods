/*
 * Copyright © Yan Zhenjie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rmbmiss.lib.utils.permission

import android.Manifest
import android.app.Activity
import android.os.Build
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：android 6.0 以上的权限申请
 * 创 建 人：IMissYou
 * 创建时间：2017/8/7 9:55
 * 修 改 人：IMissYou
 * 修改时间：2017/8/7 9:55
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
object PermissionTools {

    private var mContext: Activity? = null

    var CALENDAR: Array<String>
    var CAMERA: Array<String>
    var CONTACTS: Array<String>
    var LOCATION: Array<String>
    var MICROPHONE: Array<String>
    var PHONE: Array<String>
    var SENSORS: Array<String>
    var SMS: Array<String>  //短信权限组
    var STORAGE: Array<String>  //sd卡读写权限组

    // 声明一个集合，在后面的代码中用来存储用户拒绝授权的权
    var mPermissionList: Array<String>? = null
    var mList: MutableSet<String>? = null

    init {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            CALENDAR = arrayOf<String>()
            CAMERA = arrayOf<String>()
            CONTACTS = arrayOf<String>()
            LOCATION = arrayOf<String>()
            MICROPHONE = arrayOf<String>()
            PHONE = arrayOf<String>()
            SENSORS = arrayOf<String>()
            SMS = arrayOf<String>()
            STORAGE = arrayOf<String>()

        } else {
            CALENDAR = arrayOf(Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR)

            CAMERA = arrayOf(Manifest.permission.CAMERA)

            CONTACTS = arrayOf(Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS, Manifest.permission.GET_ACCOUNTS)

            LOCATION = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)

            MICROPHONE = arrayOf(Manifest.permission.RECORD_AUDIO)

            PHONE = arrayOf(Manifest.permission.READ_PHONE_STATE, Manifest.permission.CALL_PHONE, Manifest.permission.READ_CALL_LOG, Manifest.permission.WRITE_CALL_LOG, Manifest.permission.USE_SIP, Manifest.permission.PROCESS_OUTGOING_CALLS)

            SENSORS = arrayOf(Manifest.permission.BODY_SENSORS)

            SMS = arrayOf(Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_WAP_PUSH, Manifest.permission.RECEIVE_MMS)

            STORAGE = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
    }

    /**
     * 申请权限
     */
    fun with(context:Activity): PermissionTools {
        mContext = context
        return this
    }

    /**
     * 添加权限组
     */
    fun permission(vararg permissionsArray: Array<String>): PermissionTools {
        if (mList == null){
            mList = mutableSetOf<String>()
        }
        for (permissions in permissionsArray){
            for (miss in permissions){
                mContext?.let {
                    if (ContextCompat.checkSelfPermission(it, miss) != PackageManager.PERMISSION_GRANTED) {
                        mList?.add(miss)
                    }
                }
            }
        }
        return this
    }

    /**
     * 添加权限组
     */
    fun permission(vararg permissionsArray: String): PermissionTools {
        if (mList == null){
            mList = mutableSetOf<String>()
        }
        for (miss in permissionsArray){
            mList?.let { it.add(miss) }
        }
        return this
    }

    /**
     * 申请权限
     */
    fun requestPermissions(): PermissionTools {
        if (mPermissionList != null) {
            mContext?.let {
                //申请WRITE_EXTERNAL_STORAGE权限
                ActivityCompat.requestPermissions(it, mPermissionList!!, 0)
            }
        }
        return this
    }

    fun getPermission(): Array<String>? {
        mList?.let {
            mPermissionList = it.toTypedArray<String>()
        }
        return mPermissionList
    }
}
