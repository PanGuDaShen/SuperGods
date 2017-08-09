package com.rmbmiss.app.mian.base

import android.Manifest
import android.os.Bundle
import android.Manifest.permission
import android.support.v4.app.ActivityCompat
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import android.os.Build
import android.annotation.TargetApi
import android.app.AlertDialog
import android.graphics.Color
import android.support.annotation.RequiresApi
import android.support.v4.app.DialogFragment
import android.widget.Toast
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.dialog.AcpDialog
import com.rmbmiss.lib.utils.tools.PermissTools


/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou
 * 创建时间：2017/5/27 15:18
 * 修 改 人：IMissYou
 * 修改时间：2017/5/27 15:18
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
abstract class BaseSuperActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutView())
        initEvent()
        initData()
    }

    /**
     * 加载视图
     */
    protected abstract fun setLayoutView(): Int

    /**
     * 添加事件监听
     */
    protected abstract fun initEvent()

    /**
     * 添加数据
     */
    protected abstract fun initData()

    override fun addBarUtils() {
        if(translucentStatusBar()) {
            supportActionBar?.let { it.hide() } //!!确保是supportActionBar不为null，空引用方法报错
        }
        if (setWhenMarried()){

        }
    }

    override fun removeBarUtils() {

    }

    override fun translucentStatusBar(): Boolean {
        return true
    }

    protected var code = 100
    /**
     * 申请权限
     */
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.M)
    protected fun requestPermission(missArray: Array<String>) {
        var miss: Array<String>? = null
        if (missArray.size > 0){
            val missList = mutableListOf<String>()
            for (i in 0 until missArray.size){
                if (ContextCompat.checkSelfPermission(this, missArray[i]) != PackageManager.PERMISSION_GRANTED){
                    missList.add(missArray[i])
                }
            }
            miss = missList.toTypedArray()
        }

        miss?.let {
            if (it.size > 0){
                //申请相机权限
                ActivityCompat.requestPermissions(this,it, code)
            }else{
                Toast.makeText(this,"权限已申请",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        var boolResults = false
        var boolRationale = false
        var bool = false
        when(requestCode){
            code -> {
                if (grantResults.size > 0){
                    for (i in 0 until grantResults.size){
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            boolResults = true
                            if (!ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[i])){
                                boolRationale = true
                            }
                        }else{
                            bool = true
                        }
                    }
                }
            }
        }

        if (boolRationale){
            missNotAsking()
        }else if (boolResults){
            missRefused()
        }else if (bool){
            missThrough()
        }else {
            missNo()
        }
    }

    /**
     * 权限勾选不在询问调用
     */
    open fun missNotAsking(){
        Toast.makeText(this,"权限申请,勾选了不在询问",Toast.LENGTH_SHORT).show()
        dialogPermission( AcpDialog.newAcpDialog(null)
                .setStyleAnimont(R.style.animate_dialog)
                .setOnAcpDialoglister(object : AcpDialog.OnAcpDialoglister{
                    override fun onClick(str: String) {
                        when(str){
                            "NO" -> Toast.makeText(this@BaseSuperActivity,"您还有权限未给我",Toast.LENGTH_SHORT).show()
                            "YES" -> PermissTools.openPermissManger(this@BaseSuperActivity)
                        }
                    }

                }))
    }

    /**
     * 权限申请被拒绝调用
     */
    open fun missRefused(){
        Toast.makeText(this,"权限申请,被拒绝",Toast.LENGTH_SHORT).show()
    }

    /**
     * 权限申请全部通过调用
     */
    open fun missThrough(){
        Toast.makeText(this,"权限申请,通过",Toast.LENGTH_SHORT).show()
    }

    open fun missNo(){
        Toast.makeText(this,"当前无任何权限申请",Toast.LENGTH_SHORT).show()
    }
    /**
     * 显示一个弹出窗口
     */
    fun dialogPermission(dialog: DialogFragment){
        /**
         * 为了不重复显示dialog，在显示对话框之前移除正在显示的对话框。
         */
        val ft = supportFragmentManager.beginTransaction()
        val fragment = supportFragmentManager.findFragmentByTag("dialog")
        if (null != fragment) {
            ft.remove(fragment)
        }
        dialog.show(ft,"dialog")
    }

    /**
     * 权限检查
     */
    fun acp(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermission(arrayOf<String>(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.SEND_SMS ))
        }
    }
}