package com.rmbmiss.lib.utils.tools

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：权限组工具了
 * 创 建 人：IMissYou$
 * 创建时间：2017/8/8$ 17:35$
 * 修 改 人：IMissYou$
 * 修改时间：2017/8/8$ 17:35$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
object PermissTools {
    var CALENDAR: Array<String>
    var CAMERA: Array<String>
    var CONTACTS: Array<String>
    var LOCATION: Array<String>
    var MICROPHONE: Array<String>
    var PHONE: Array<String>
    var SENSORS: Array<String>
    var SMS: Array<String>  //短信权限组
    var STORAGE: Array<String>  //sd卡读写权限组

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
     * 打开app权限设置页面
     */
    fun openPermissManger(content: Activity){
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", content.getPackageName(), null)
        intent.data = uri
        content.startActivityForResult(intent,300)
    }
}