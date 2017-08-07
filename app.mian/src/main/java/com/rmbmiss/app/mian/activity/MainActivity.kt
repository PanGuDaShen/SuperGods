package com.rmbmiss.app.mian.activity

import android.content.Intent
import android.os.Build
import android.widget.Toast
import co.aenterhy.toggleswitch.ToggleSwitchButton
import com.blankj.utilcode.util.LogUtils
import com.rmbmiss.app.mian.R
import com.rmbmiss.app.mian.adapter.SampleFragmentPagerAdapter
import com.rmbmiss.app.mian.base.BaseSuperActivity
import com.rmbmiss.app.mian.databean.SamplePagerItem
import com.rmbmiss.lib.utils.permission.OnPermissListener
import com.rmbmiss.lib.utils.permission.PermissionTools
import com.rmbmiss.nicetablibrary.NiceTabLayout
import com.rmbmiss.nicetablibrary.NiceTabStrip
import kotlinx.android.synthetic.main.activity_main.*

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
        xxxxxx.setOnClickListener {
            acp()
        }
    }

    override fun initData() {
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
    fun invaliBadge(map: MutableMap<Int,String>?){
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

//        /**
//         * 为了不重复显示dialog，在显示对话框之前移除正在显示的对话框。
//         */
//        val ft = supportFragmentManager.beginTransaction()
//        val fragment = supportFragmentManager.findFragmentByTag("dialog")
//        if (null != fragment) {
//            ft.remove(fragment)
//        }
//
//        AcpDialog.newAcpDialog(null)
//                .setStyleAnimont(R.style.animate_dialog)
//                .setOnAcpDialoglister(object : AcpDialog.OnAcpDialoglister{
//                    override fun onClick(str: String) {
//                        when(str){
//                            "NO" -> Toast.makeText(this@MainActivity,"$str",Toast.LENGTH_SHORT).show()
//                            "YES" -> Toast.makeText(this@MainActivity,"$str",Toast.LENGTH_SHORT).show()
//                        }
//                    }
//
//                }).show(ft,"dialog")

        // 申请多个权限。
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            PermissionUtils.requestPermissions(this,1,PermissionTools.permission(PermissionTools.PHONE).getPermission(),object :PermissionUtils.OnPermissionListener{
//                override fun onPermissionGranted() {
//                    Toast.makeText(this@MainActivity,"无权限申请时处理",Toast.LENGTH_SHORT).show()
//                }
//                override fun onPermissionDenied(deniedPermissions: Array<out String>?) {
//                    Toast.makeText(this@MainActivity,"权限申请处理",Toast.LENGTH_SHORT).show()
//                }
//            },object :PermissionUtils.RationaleHandler(){
//                override fun showRationale() {
//                    Toast.makeText(this@MainActivity,"权限申请用户勾选不在询问时处理",Toast.LENGTH_SHORT).show()
//                }
//            })

            PermissionTools.with(this)
                .setCodes(1)
                .permission(PermissionTools.PHONE,PermissionTools.SMS)
                .getPermission()
                .addOnPermissListener(object :OnPermissListener{
                    override fun onSourse() {
                        Toast.makeText(this@MainActivity,"OK",Toast.LENGTH_SHORT).show()
                    }
                    override fun onRationale(code: Int, ra: MutableSet<String>) {
                        Toast.makeText(this@MainActivity,"权限申请用户拒绝时处理",Toast.LENGTH_SHORT).show()
                        for (str in ra){
                            LogUtils.e("=================="+str)
                        }
                    }
                    override fun onNoRequce(code: Int, no: MutableSet<String>) {
                        Toast.makeText(this@MainActivity,"权限申请用户勾选不在询问时处理",Toast.LENGTH_SHORT).show()
                        for (str in no){
                            LogUtils.e("*******************"+str)
                         }
                        PermissionTools.openPermissManger(this@MainActivity)
                    }
                })
                .requestPermissions()
        }
    }

}
