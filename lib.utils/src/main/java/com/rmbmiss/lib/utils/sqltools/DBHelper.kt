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
class DBHelper(mContext: Context, mName: String?): DatabaseOpenHelper(mContext, mName,null, 2) {
    private var mContext: Context?=null
    private var mName:String?=null
    private var mNewVersion: Int=0
    init {
        this.mContext = mContext
        this.mName = mName
    }

    override fun onCreate(db: SQLiteDatabase) {
        mName?.let {
            when(it){
                "mian.db" -> {
                    Toast.makeText(mContext,"$mName",Toast.LENGTH_SHORT).show()
                    db.execSQL(NavigaTionTable.naviga)
                    db.execSQL(NavigaTionTable.insertNaviga)
                }
                "mall.db" -> {Toast.makeText(mContext,"$mName",Toast.LENGTH_SHORT).show()}
                "news.db" -> {Toast.makeText(mContext,"$mName",Toast.LENGTH_SHORT).show()}
                else -> {
                    Toast.makeText(mContext,"错误的数据库！",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Toast.makeText(mContext,"111111111111111",Toast.LENGTH_SHORT).show()
    }


}
