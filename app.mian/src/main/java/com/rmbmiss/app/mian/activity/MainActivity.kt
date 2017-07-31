package com.rmbmiss.app.mian.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Environment
import android.telephony.TelephonyManager
import android.view.View
import android.widget.Toast
import co.aenterhy.toggleswitch.ToggleSwitchButton
import com.blankj.utilcode.util.LogUtils
import com.mylhyl.acp.Acp
import com.mylhyl.acp.AcpListener
import com.mylhyl.acp.AcpOptions
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.adapter.SampleFragmentPagerAdapter
import com.rmbmiss.app.mian.base.BaseSuperActivity
import com.rmbmiss.app.mian.databean.SamplePagerItem
import com.rmbmiss.lib.utils.pathtools.DirPathTools
import com.rmbmiss.nicetablibrary.NiceTabLayout
import com.rmbmiss.nicetablibrary.NiceTabStrip
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : BaseSuperActivity() ,NiceTabStrip.OnIndicatorColorChangedListener
{

    private val mTexts = mutableListOf<String>("0000000000","11111111111111","222222222","3333333333333333333","444444","55","66","77")
    private val mIconRound = mutableListOf<Int>(R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher
            ,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher)
    private val mIcon = mutableListOf<Int>(R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round
            ,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round)
    private val mColor = mutableListOf<Int>(R.color.colorAccent,R.color.colorAccent,R.color.colorAccent,R.color.colorAccent,
            R.color.colorAccent,R.color.colorAccent,R.color.colorAccent,R.color.colorAccent)
    private val mClolorRound = mutableListOf<Int>(R.color.colorPrimary,R.color.colorPrimary,R.color.colorPrimary,R.color.colorPrimary,
            R.color.colorPrimary,R.color.colorPrimary,R.color.colorPrimary,R.color.colorPrimary)
    private val mBageMap = mutableMapOf<Int,String>(1 to "1",2 to "12",3 to "123",4 to "1234")

    private val mTabs = mutableListOf<SamplePagerItem>()    //tab 列表

    override fun setLayoutView(): Int {
        return R.layout.activity_main
    }

    override fun initEvent() {
        id_main_ntl_1.let {
            it.setTabStripColorize(object: NiceTabStrip.TabStripColorize{
                override fun getIndicatorColor(position: Int): Int {
                    return mTabs[position].getIndicatorColor()
                }

                override fun getDividerColor(position: Int): Int {
                    return mTabs[position].getDividerColor()
                }
            })
//
//        it.setTabColorize(object : NiceTabLayout.TabColorize{
//            override fun getDefaultTabColor(position: Int): Int {
//                return Color.WHITE
//            }
//
//            override fun getSelectedTabColor(position: Int): Int {
//                return mTabs[position].getIndicatorColor()
//            }
//
//        })
            it.setOnIndicatorColorChangedListener(this)
        }

        id_main_tsb_1.setOnTriggerListener(object : ToggleSwitchButton.OnTriggerListener {
            override fun toggledUp() {
                startActivity(Intent(applicationContext,NavigationActivity::class.java))
            }

            override fun toggledDown() {
                startActivity(Intent(applicationContext,SetUpActivity::class.java))
            }
        })
    }

    override fun initData() {
        acp()
        for (i in 0 until mTexts.size){
            mTabs.add(i, SamplePagerItem(mTexts[i],mIcon[i],mIconRound[i],mColor[i],mClolorRound[i]))
        }
        id_mian_vp_1.adapter = SampleFragmentPagerAdapter(mTabs,supportFragmentManager)
        id_main_ntl_1.setViewPager(id_mian_vp_1)
        invaliBadge(mBageMap)
    }

    /**
     * 颜色监听
     * @param color 当前渐变颜色值
     */
    override fun onIndicatorColorChanged(tabLayout: NiceTabLayout?, color: Int) {

    }

    /**
     * 设置信息提示个数
     */
    fun invaliBadge(map: MutableMap<Int,String>){
        map?.let {
            it.forEach {
                //key 代表第几个item  ，value 代表显示的内容
                id_main_ntl_1.setBadge(it.key,it.value)
            }
            // 总共要显示内容的个数
            id_main_ntl_1.setBadgeSmall(it.size)
        }
    }

    /**
     * 清除设置信息提示个数
     */
    fun clearBadge() {
        id_main_ntl_1.clearBadge()
    }

    /**
     * 重新绘制（刷新界面）控件
     */
    fun invalidateBlur() {
        id_main_ntl_1.invalidateBlur()
    }

    /**
     * 权限检查
     */
    fun acp(){
        Acp.getInstance(this)
                .request(AcpOptions.Builder().setPermissions(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                ).build(),object :AcpListener{
                    // 权限允许
                    override fun onGranted() {
                        Toast.makeText(applicationContext,"权限允许",Toast.LENGTH_SHORT).show()
                        writeSD()
                    }
                    // 权限拒绝
                    override fun onDenied(permissions: MutableList<String>?) {
                        Toast.makeText(applicationContext,"权限拒绝",Toast.LENGTH_SHORT).show()
                        finish()
                    }

                })
    }

    private fun writeSD() {
        val acpDir = getCacheDir("acp", applicationContext)
        if (acpDir != null)
            Toast.makeText(applicationContext,"写SD成功：" + acpDir.absolutePath,Toast.LENGTH_SHORT).show()
    }

    private fun getIMEI() {
        val tm = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if (tm != null)
            Toast.makeText(applicationContext,"读imei成功：" + tm.deviceId,Toast.LENGTH_SHORT).show()
    }

    fun getCacheDir(dirName: String, context: Context): File? {
        val result: File
        if (existsSdcard()) {
            val cacheDir = context.externalCacheDir
            if (cacheDir == null) {
                result = File(Environment.getExternalStorageDirectory(),
                        "Android/data/" + context.packageName + "/cache/" + dirName)
            } else {
                result = File(cacheDir, dirName)
            }
        } else {
            result = File(context.cacheDir, dirName)
        }
        if (result.exists() || result.mkdirs()) {
            return result
        } else {
            return null
        }
    }

    fun existsSdcard(): Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    }
}
