package com.rmbmiss.lib.utils.sqltools

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：数据库操作工具类
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/21$ 17:33$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/21$ 17:33$
 * 修改备注：Android提供了一个名为SQLiteDatabase的类，该类封装了一些操作数据库的API，
 * 使用该类可以完成对数据进行添加(Create)、查询(Retrieve)、更新(Update)和删除(Delete)操作（这些操作简称为CRUD）。
 * 对SQLiteDatabase的学习，我们应该重点掌握execSQL()和rawQuery()方法。
 * execSQL()方法可以执行insert、delete、update和CREATE TABLE之类有更改行为的SQL语句；
 * rawQuery()方法用于执行select语句。
 * 参考csdn博客：http://blog.csdn.net/codeeer/article/details/30237597/
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
object SqlAnroidTools {

    //数据库表操盘手
    private var db:SQLiteDatabase? = null

    /**
     * 不使用固定语句
     */
    fun getDb(ku:Int,content:Context):SQLiteDatabase?{
        if (db == null){
            sqlSwitch(ku,content)
        }
        return db
    }

    /**
     * 切换要操作的数据库
     * @param ku 数据库名
     * @param content上下文
     */
    fun sqlSwitch(ku:Int,content:Context):SqlAnroidTools{
        when(ku){
            0 -> db = DBHelper(content,"mian_settings.db").writableDatabase // main宿主数据库
            1 -> db = DBHelper(content,"mall_settings.db").writableDatabase // mall商场数据库
            2 -> db = DBHelper(content,"news_settings.db").writableDatabase // news新闻数据库
        }
        return this
    }

    /**
     * @param table 数据库表
     * @param cValue ContentValues类型的一个封装了列名称和列值的Map
     * 增，
     * 【插入单行】：insert into 表名 (列名，列名，列名) values (列值，列值，列值)
     * 【将现有表数据添加到一个已有表】：insert into 已有的新表名 (列名，列名，列名) select <原表列名，原表列名，原表列名> from <原表名>
     */
    fun insert (table:String,cValue:ContentValues){
        db?.let {
            //参数2  空列的默认值
            it.insert(table,null,cValue)
        }
    }

    /**
     * 删
     * @param table 数据库表
     * @param where 删除条件
     * @param args 删除条件参数数组
     */
    fun delete(table:String?,where:String?,args:Array<String>?){
        db?.let {
            it.delete(table,where,args)
        }
    }

    /**
     * 改
     * 参数1  表名称
     * 参数2  跟行列ContentValues类型的键值对Key-Value
     * 参数3  更新条件（where字句）
     * 参数4  更新条件数组
     */
    fun update(table:String,cValues:ContentValues,whereClause:String,whereArgs:Array<String>){
        db?.let {
            it.update(table,cValues,whereClause,whereArgs)
        }
    }

    /**
     * 查
     */
    fun select(table: String){
        drop(table)
    }

    /**
     * 参数table:表名称
     * 参数columns:列名称数组
     * 参数selection:条件字句，相当于where
     * 参数selectionArgs:条件字句，参数数组
     * 参数groupBy:分组列
     * 参数having:分组条件
     * 参数orderBy:排序列
     * 参数limit:分页查询限制
     * 参数Cursor:返回值，相当于结果集ResultSet
     */
    fun drop(table: String){
        db?.let {
            val cursor = it.query(table,null,null,null,null,null,null)
            //判断游标是否为空
            if (cursor.moveToFirst()){
                //遍历游标
                for (i in 0 until cursor.count){
                    cursor.move(i)
                    val id = cursor.getInt(0)
                    //获得用户名
                    val username = cursor.getString(1)
                    //获得密码
                    val password = cursor.getString(2)
                }
            }
        }
    }

    /**
     * 打开或者创建数据库
     * @param path 数据库创建的路径
     */
    fun openCreteSql(path:String?,content: Context){
        var ph = path
        if (ph == null){
            ph = content.filesDir.path+"stu.db"
        }
        //创建数据库
       var db=SQLiteDatabase.openOrCreateDatabase(ph,null);

    }


    /******************************************************************************************************/

    /**
     * @param strSql 执行sql语句
     * @param agrs
     * 【插入单行】：insert into 表名 (列名，列名，列名) values (列值，列值，列值)
     * 【将现有表数据添加到一个已有表】：insert into 已有的新表名 (列名，列名，列名) select <原表列名，原表列名，原表列名> from <原表名>
     */
    fun execSQL(strSql:String,agrs:Array<*>){
        db?.let {
            if (agrs == null){
                it.execSQL(strSql)
            }else{
                it.execSQL(strSql,agrs)
            }
        }
    }
}