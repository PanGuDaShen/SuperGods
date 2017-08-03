package com.rmbmiss.lib.utils.sqltools

import java.io.File
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.os.Environment
import android.util.Log
import com.blankj.utilcode.util.LogUtils

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：自定义打开创建数据库帮助类，目的为了改变原来的DB保存路径，重新指定一个新的路径
 * 创 建 人：IMissYou$
 * 创建时间：2017/8/1$ 9:45$
 * 修 改 人：IMissYou$
 * 修改时间：2017/8/1$ 9:45$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
abstract class DatabaseOpenHelper(private val mContext: Context, private val mName: String?,
                                  private val mFactory: CursorFactory?, private val mNewVersion: Int) {
    private var mDatabase: SQLiteDatabase? = null
    private var mIsInitializing = false

    val writableDatabase: SQLiteDatabase?
        @Synchronized get() {
            if (mDatabase != null && mDatabase!!.isOpen && !mDatabase!!.isReadOnly) {
                return mDatabase
            }
            if (mIsInitializing) {
                throw IllegalStateException("getWritableDatabase called recursively")
            }
            var success = false
            var db: SQLiteDatabase? = null
            try {
                mIsInitializing = true
                if (mName == null) {
                    db = SQLiteDatabase.create(null)
                } else {
                    val path = databasePath.path
                    db = SQLiteDatabase.openOrCreateDatabase(path, mFactory)
                }
                val version = db!!.version
                if (version != mNewVersion) {
                    db.beginTransaction()
                    try {
                        if (version == 0) {
                            onCreate(db)
                        } else {
                            onUpgrade(db, version, mNewVersion)
                        }
                        db.version = mNewVersion
                        db.setTransactionSuccessful()
                    } finally {
                        db.endTransaction()
                    }
                }
                onOpen(db)
                success = true
                return db
            } finally {
                mIsInitializing = false
                if (success) {
                    if (mDatabase != null) {
                        try {
                            mDatabase!!.close()
                        } catch (e: Exception) {
                        }

                    }
                    mDatabase = db
                } else {
                    if (db != null)
                        db.close()
                }
            }
        }

    val readableDatabase: SQLiteDatabase?
        @Synchronized get() {
            if (mDatabase != null && mDatabase!!.isOpen) {
                return mDatabase
            }
            if (mIsInitializing) {
                throw IllegalStateException("getReadableDatabase called recursively")
            }
            try {
                return writableDatabase
            } catch (e: SQLiteException) {
                if (mName == null)
                    throw e
            }

            var db: SQLiteDatabase? = null
            try {
                mIsInitializing = true
                val path = databasePath.path
                LogUtils.e("path===$path")

                db = SQLiteDatabase.openDatabase(path, mFactory,
                        SQLiteDatabase.OPEN_READWRITE)
                if (db!!.version != mNewVersion) {
                    throw SQLiteException(
                            "Can't upgrade read-only database from version "
                                    + db.version + " to " + mNewVersion + ": "
                                    + path)
                }
                onOpen(db)
                mDatabase = db
                return mDatabase
            } finally {
                mIsInitializing = false
                if (db != null && db != mDatabase)
                    db.close()
            }
        }

    @Synchronized fun close() {
        if (mDatabase != null && mDatabase!!.isOpen) {
            mDatabase!!.close()
            mDatabase = null
        }
    }

    /** 获取数据库保存路径  */
    // 判断是否有SDcard
    // 判断是否存在指定的文件夹，如果没有就创建它
    val databasePath: File
        get() {
            val sbPath = StringBuffer()
            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                sbPath.append(android.os.Environment.getExternalStorageDirectory().absolutePath + File.separator + "name")
                sbPath.append(File.separator + "name1" + File.separator)
            } else {
                sbPath.append(mContext.cacheDir.toString() + File.separator + "name")
                sbPath.append(File.separator + "name1" + File.separator)
            }
            val f = File(sbPath.toString())
            if (!f.exists()) {
                f.mkdirs()
            }
            return File(sbPath.toString() + mName!!)
        }

    abstract fun onCreate(db: SQLiteDatabase)

    abstract fun onUpgrade(db: SQLiteDatabase, oldVersion: Int,
                           newVersion: Int)

    fun onOpen(db: SQLiteDatabase) {

    }
}
