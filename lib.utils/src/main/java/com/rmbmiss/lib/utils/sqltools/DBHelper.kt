package com.rmbmiss.lib.utils.sqltools

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase.CursorFactory
import com.blankj.utilcode.util.LogUtils
import com.rmbmiss.lib.utils.errortools.ErrorStringTools
import com.rmbmiss.lib.utils.pathtools.DirPathTools


/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/21$ 16:45$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/21$ 16:45$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class DBHelper(context: Context,name:String): SQLiteOpenHelper(context, name, null, version) {

    /**
     * 数据库列表：
     * （1）attribute_settings  界面显示属性设置
     * （2）system_settings  app系统属性设置
     */
    private var dbName = "mian_settings" //数据库名称

    init {
        dbName = name
    }

    companion object {
        private val version = 1 //数据库版本，要更新数据库，修改此值+1
    }

    /**
     * 创建数据库表调用，如果是第一次创建数据库，则会执行这个方法，用于初始化数据库表用。
     * @param db
     */
    override fun onCreate(db: SQLiteDatabase) {
        when(dbName){
            // mall商城系统设置
            "mall_settings.db" -> {

            }
            // mian宿主app系统设置
            "mian_settings.db" -> {
                //执行SQL语句,创建表
                db.execSQL(NavigaTionTable.stu_table)
            }
            // news新闻系统设置
            "news_settings.db" -> {

            }
            else -> {
                ErrorStringTools.showString("不能创建${dbName}数据库表，请联系相关技术人员处理，谢谢！")
            }
        }
        // 创建数据库
        // SQLiteDatabase.openOrCreateDatabase("${DirPathTools.getDatabasePath(content,null)}/$dbName",null)
        // 创建数据库表（也可以多创建几张表）
        // db.execSQL("CREATE TABLE IF NOT EXISTS person (personid integer primary key autoincrement, name varchar(20), age INTEGER)")
    }

    /**
     * 更新数据库表调用，在修改版本好后，更新数据库表调用。
     * @param db
     * @param i
     * @param i1
     */
    override fun onUpgrade(db: SQLiteDatabase, i: Int, i1: Int) {
        when(dbName){
        // mall商城系统设置
            "mall_settings.db" -> {
                SQLiteDatabase.openOrCreateDatabase(dbName,null)
            }
        // mian宿主app系统设置
            "mian_settings.db" -> {
                SQLiteDatabase.openOrCreateDatabase(dbName,null)
            }
        // news新闻系统设置
            "news_settings.db" -> {
                SQLiteDatabase.openOrCreateDatabase(dbName,null)
            }
            else -> {//检查非法数据库是否存在，如果存在就删除。

                ErrorStringTools.showString("不能更新${dbName}数据库表，请联系相关技术人员处理，谢谢！")
            }
        }
        // 更新数据库表（也可以同时更新几张）
        db.execSQL("ALTER TABLE person ADD phone VARCHAR(12)") //往表中增加一列
    }

    /**
     * 当打开数据库成功时最先调用，这里可以检查当前用户是否有权限打开这个数据库。
     * 目前没有设置用户权限
     */
    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
    }
    /**
     * 获取当前正在操作的数据库
     */
    fun getDbName():String = dbName
}
