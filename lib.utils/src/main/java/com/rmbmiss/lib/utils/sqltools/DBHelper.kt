package com.rmbmiss.lib.utils.sqltools

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.widget.Toast
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
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
class DBHelper(context: Context,dbName:String): SQLiteOpenHelper(context, dbName, null, 2) {

    private var dbName:String?=null

    init {
        this.dbName = dbName
    }

    override fun onCreate(db: SQLiteDatabase) {
        when(dbName){
            "mian.db" -> db.execSQL("create table person(id integer primary key autoincrement,name char(20),salary char(20),phone char(20))")//db.execSQL(NavigaTionTable.naviga_tion)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {

    }

}
