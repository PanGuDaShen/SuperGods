package com.rmbmiss.lib.utils.permission

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.blankj.utilcode.util.LogUtils

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
    private var mPermissionArray: Array<String>? = null
    private var mList: MutableSet<String>? = null

    var code = 0

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
     * 初始化申请权限
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
                    if (selfPermiss(miss)){
                        mList?.add(miss)
                        LogUtils.e("++++++++++++++++++++++++++"+miss)
                    }
                }
            }
        }
        return this
    }

    /**
     * 添加非权限组
     */
    fun permission(vararg permissionsArray: String): PermissionTools {
        if (mList == null){
            mList = mutableSetOf<String>()
        }
        for (miss in permissionsArray){
            mList?.let { 
                if (selfPermiss(miss)){
                    it.add(miss)
                }
            }
        }
        return this
    }

    fun setCodes(code:Int): PermissionTools {
        this.code = code
        return this
    }

    /**
     * 申请权限
     */
    fun requestPermissions(): PermissionTools {
        if (mContext != null) {
            mPermissionArray?.let {
                if (it.size > 0) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(mContext!!, it, code)
                }
            }
        }
        return this
    }

    /**
     * set权限集合转化成数组权限集合
     */
    fun getPermission(): PermissionTools {
        mList?.let {
            mPermissionArray = it.toTypedArray<String>()
        }
        return this
    }

    /**
     * 检查权限
     */
    fun selfPermiss(miss:String):Boolean{
        // 需要进行申请授权
        if (ContextCompat.checkSelfPermission(mContext!!,miss) == PackageManager.PERMISSION_DENIED){
            return true
        }
        return false
    }

    /**
     * 用户是否勾选不在询问,true 没有，false 有
     */
    fun showPermiss(miss: String): Boolean{
        mContext?.let {
            if (ActivityCompat.shouldShowRequestPermissionRationale(it,miss)){
                return false
            }
        }
        return true
    }

    /**
     * 回调处理
     */
    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            code -> {

                var ra = mutableSetOf<String>()
                var no = mutableSetOf<String>()

                if (grantResults.size > 0){
                    for (i in 0 until grantResults.size){
                        if (grantResults[i] == PackageManager.PERMISSION_DENIED){ // 未授权调用
                            if (showPermiss(permissions[i])){ // 勾选不在询问调用
                                no.add(permissions[i])
                            }else{ // 拒绝权限调用
                                ra.add(permissions[i])
                            }
                        }
                    }
                    onPermissListener?.let {
                        if (ra.size > 0) {
                            it.onRationale(code,ra)  // 不在询问调用
                        }else if (no.size > 0) {
                            it.onNoRequce(code,no) //拒绝权限调用
                        }else {
                            it.onSourse()
                        }
                    }
                }else{
                    onPermissListener?.let {it.onSourse()}
                }
            }
        }
    }

    private var onPermissListener:OnPermissListener? = null

    fun addOnPermissListener(listener:OnPermissListener): PermissionTools {
        onPermissListener = listener
        return this
    }

    /**
     * 打开app权限设置页面
     */
    fun openPermissManger(content:Activity){
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", content.getPackageName(), null)
        intent.data = uri
        content.startActivityForResult(intent,300)
    }
}
