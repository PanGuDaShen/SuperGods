package com.rmbmiss.lib.utils.pathtools

import android.content.Context
import android.os.Build
import android.os.Environment

import com.blankj.utilcode.util.LogUtils
import java.io.File
import java.lang.reflect.Method

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：手机存储路径
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/24$ 15:02$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/24$ 15:02$
 * 修改备注：../data/..(内部存储)；../sdcard/..或../mnt/..(内置 SD 卡/外置 SD 卡)
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
object DirPathTools {
    /**************************************************重量级********************************************/

    /**
     * 得到所有的存储路径（内部存储+外部存储）
     * 通过反射：
     * paths[0] 手机内存储
     * paths[1] 手机外存储
     * 测试对比手机文件管理器判断对错
     */
    fun getAllSdPaths(context: Context):Array<String>?{
        //通过调用类的实例mStorageManager的getClass()获取StorageManager类对应的Class对象
        val mStorageManager = context.getSystemService(Context.STORAGE_SERVICE)
        //getMethod("getVolumePaths")返回StorageManager类对应的Class对象的getVolumePaths方法，这里不带参数
        val mMethod = mStorageManager.javaClass.getMethod("getVolumePaths")
        val paths = mMethod.invoke(mStorageManager)
        return paths as Array<String>?
    }

    /**************************************************系统级********************************************/
    //:/system系统根目录
    fun getRootDirectory():File{
        LogUtils.e("Environment.getRootDirectory()=: ${Environment.getRootDirectory()}")
        return Environment.getRootDirectory()
    }

    //:/data 用户数据目录
    fun getDataDirectory():File{
        LogUtils.e("Environment.getDataDirectory()=: ${Environment.getDataDirectory()}")
        return Environment.getDataDirectory()
    }

    //:/cache 下载缓存内容目录
    fun getDownloadCacheDirectory():File{
        LogUtils.e("Environment.getDownloadCacheDirectory()=: ${Environment.getDownloadCacheDirectory()}")
        return Environment.getDownloadCacheDirectory()
    }

    //:/mnt/sdcard或者/storage/emulated/0或者/storage/sdcard0 主要的外部存储目录
    fun getExternalStorageDirectory():File{
        LogUtils.e("Environment.getExternalStorageDirectory()=: ${Environment.getExternalStorageDirectory()}")
        return Environment.getExternalStorageDirectory()
    }

    /**
     * :/mnt/sdcard/Pictures或者/storage/emulated/0/Pictures或者/storage/sdcard0/Pictures
     * 获取一个顶级公共外部存储目录，用于放置特定类型的文件（共享文件）。
     * Environment.DIRECTORY_ALARMS 系统提醒铃声存放的标准目录。
     * Environment.DIRECTORY_DCIM 相机拍摄照片和视频的标准目录。
     * Environment.DIRECTORY_DOWNLOADS 下载的标准目录。
     * Environment.DIRECTORY_MOVIES 电影存放的标准目录。
     * Environment.DIRECTORY_MUSIC 音乐存放的标准目录。
     * Environment.DIRECTORY_NOTIFICATIONS 系统通知铃声存放的标准目录。
     * Environment.DIRECTORY_PICTURES 图片存放的标准目录。
     * Environment.DIRECTORY_PODCASTS系统广播存放的标准目录。
     * Environment.DIRECTORY_RINGTONES 系统铃声存放的标准目录。
     * Environment.DIRECTORY_DOCUMENTS 文档存放的标准目录
     */
    fun getSdcardPictures(dir:String):File{
        LogUtils.e("Environment.getExternalStoragePublicDirectory()=: ${Environment.getExternalStoragePublicDirectory(dir)}")
        return Environment.getExternalStoragePublicDirectory(dir)
    }

    /**
     * 获取SD卡是否存在:mounted，获得当前外部储存媒体的状态。
     * Environment.MEDIA_BAD_REMOVAL 在没有挂载前存储媒体已经被移除。
     * Environment.MEDIA_CHECKING 正在检查存储媒体。
     * Environment.MEDIA_MOUNTED 存储媒体已经挂载，并且挂载点可读/写。
     * Environment.MEDIA_MOUNTED_READ_ONLY 存储媒体已经挂载，挂载点只读。
     * Environment.MEDIA_NOFS 存储媒体是空白或是不支持的文件系统。
     * Environment.MEDIA_REMOVED 存储媒体被移除。
     * Environment.MEDIA_SHARED 存储媒体正在通过USB共享。
     * Environment.MEDIA_UNMOUNTABLE 存储媒体无法挂载。
     * Environment.MEDIA_UNMOUNTED 存储媒体没有挂载。
     * Environment.MEDIA_EJECTING 存储媒体正在移除
     * Environment.MEDIA_UNKNOWN 未知的存储媒体(未识别)
     */
    fun getExternalStorageState():String{
        LogUtils.e("Environment.getExternalStorageState()=: ${Environment.getExternalStorageState()}")
        return Environment.getExternalStorageState()
    }

    // 设备的外存是否是用内存模拟的，是则返回true。(API Level 11)
    fun isExternalStorageEmulated():Boolean{
        LogUtils.e("Environment.isExternalStorageEmulated()=: ${Environment.isExternalStorageEmulated()}")
        return Environment.isExternalStorageEmulated()
    }

    //设备的外存是否是可以拆卸的，比如SD卡，是则返回true。(API Level 9)
    fun isExternalStorageRemovable():Boolean{
        LogUtils.e("Environment.isExternalStorageRemovable()= : ${Environment.isExternalStorageRemovable()}")
        return Environment.isExternalStorageRemovable()
    }

    /**************************************************应用级********************************************/

    /**
     * 删除指定文件
     */
    fun deleteFile(context: Context,file: String){
        LogUtils.e("context.deleteFile()=: ${context.deleteFile(file) }")
        context.deleteFile(file)
    }

    // 删除指定数据库.db文件，/data/data/包名/databases/file
    fun deleteDatabase(context: Context,name: String){
        LogUtils.e("context.deleteDatabase()=: ${context.deleteDatabase(name) }")
        context.deleteDatabase(name)
    }

    // 删除指定SP文件（API 24），/data/data/包名/shared_prefs
    fun deleteSharedPreferences(context: Context,file: String){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LogUtils.e("context.deleteSharedPreferences()=: ${context.deleteSharedPreferences(file) }")
            context.deleteSharedPreferences(file)
        }
    }

    ///data/data/包名/databases
    fun getDataDir(context: Context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LogUtils.e("context.getDataDir()=: ${context.dataDir }")
            context.dataDir
        }
    }

    // /data/data/包名/app_name
    fun getDir(context: Context,name:String,mode:Int){
        LogUtils.e("context.getDir()=: ${context.getDir(name,mode) }")
        context.getDir(name,mode)
    }

    fun getFileStreamPath(context: Context,name:String):File{
        LogUtils.e("context.getFileStreamPath()=: ${context.getFileStreamPath(name) }")
        return context.getFileStreamPath(name)
    }

    fun getCodeCacheDir(context: Context):File?{
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            LogUtils.e("context.getCodeCacheDir()=: ${context.codeCacheDir }")
            return context.codeCacheDir
        }
        return null
    }

    fun getNoBackupFilesDir(context: Context):File?{
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            LogUtils.e("context.getNoBackupFilesDir()=: ${context.noBackupFilesDir }")
            return context.noBackupFilesDir
        }
        return null
    }

    fun getObbDir(context: Context):File{
        LogUtils.e("context.getObbDir()=: ${context.obbDir }")
       return context.obbDir
    }
    //获取指定路径目录下的所有路径
    fun getExternalFilesDirs(context: Context,dir: String):Array<File>{
        var arr = context.getExternalFilesDirs(dir)
        for (i in 0 until arr.size)
        {
            LogUtils.e("context.getExternalFilesDirs()=: ${arr[i]}")
        }
        return context.getExternalFilesDirs(dir)
    }

    // 获取当前程序路径 应用在内存储上的目录 :/data/data/包名/files
    fun getFilesDir(context: Context):File{
        LogUtils.e("context.getFilesDir()=: ${context.filesDir}")
        return context.filesDir
    }
    // 应用的在内存储上的缓存目录 :/data/data/包名/cache
    fun getCacheDir(context: Context):File{
        LogUtils.e("context.getCacheDir()=: ${context.getCacheDir() }")
        return context.cacheDir
    }

    /**
     * 应用在外部存储上的目录 :/storage/emulated/0/Android/data/com.rmbmiss.supergod/files/Movies
     * Environment.DIRECTORY_ALARMS 系统提醒铃声存放的标准目录。
     * Environment.DIRECTORY_DCIM 相机拍摄照片和视频的标准目录。
     * Environment.DIRECTORY_DOWNLOADS 下载的标准目录。
     * Environment.DIRECTORY_MOVIES 电影存放的标准目录。
     * Environment.DIRECTORY_MUSIC 音乐存放的标准目录。
     * Environment.DIRECTORY_NOTIFICATIONS 系统通知铃声存放的标准目录。
     * Environment.DIRECTORY_PICTURES 图片存放的标准目录。
     * Environment.DIRECTORY_PODCASTS系统广播存放的标准目录。
     * Environment.DIRECTORY_RINGTONES 系统铃声存放的标准目录。
     * Environment.DIRECTORY_DOCUMENTS 文档存放的标准目录
     */
    fun getExternalFilesDir(context: Context,dir:String):File{
        LogUtils.e("context.getExternalFilesDir()=: ${context.getExternalFilesDir(dir)}")
        return context.getExternalFilesDir(dir)
    }

    // 应用的在外部存储上的缓存目录 :/storage/emulated/0/Android/data/包名/cache
    fun getExternalCacheDir(context: Context):File{
        LogUtils.e("context.getExternalCacheDir()=: ${context.externalCacheDir}")
        return context.externalCacheDir
    }

    //获取该程序的下载安装包路径 :/data/app/包名.apk
    fun getPackageResourcePath(context: Context):String{
        LogUtils.e("context.getPackageResourcePath()=: ${context.packageResourcePath}")
        return context.packageResourcePath
    }

    //获取程序默认数据库路径 :/data/data/com.rmbmiss.supergod/databases/mufeng
    fun getDatabasePath(context: Context,mufeng:String?):File{
        // 默认数据库存储路径
        if (mufeng == null){
            LogUtils.e("context.getDatabasePath(\"mufeng\")=:${context.getDatabasePath("mufeng")}")
            return context.getDatabasePath("mufeng")
        }
        // 指定数据库存储路径
        LogUtils.e("context.getDatabasePath(\"$mufeng\")=:${context.getDatabasePath(mufeng)}")
        return context.getDatabasePath(mufeng)
    }

/**===================================================================测试级==========================================================================

    //目录路径测试
    fun getPathTest(context: Context){

    **************************************************系统级********************************************
        getRootDirectory()
        getDataDirectory()
        getDownloadCacheDirectory()
        getExternalStorageDirectory()
        getSdcardPictures("AAAA")
        getExternalStorageState()
        isExternalStorageEmulated()
        isExternalStorageRemovable()

    **************************************************应用级********************************************
        deleteFile(context,"AAAA")
        deleteDatabase(context,"AAAA")
        deleteSharedPreferences(context,"AAAA")
        getDataDir(context)
        getDir(context,"AAAA",0)
        getFileStreamPath(context,"AAAA")
        getCodeCacheDir(context)
        getNoBackupFilesDir(context)
        getObbDir(context)
        getExternalFilesDirs(context,"AAAA")
        getFilesDir(context)
        getCacheDir(context)
        getExternalFilesDir(context,"xx11")
        getExternalCacheDir(context)
        getPackageResourcePath(context)
        getDatabasePath(context,"AAAA")

    }

    **++++++++++++++++++++++++++++++++++++++++++++++++++++系统级+++++++++++++++++++++++++++++++++++++++++++++++++++++
    getRootDirectory() = /system      [ 系统根目录 ]
    getDataDirectory() = /data      [ 内存储根目录 ]
    getDownloadCacheDirectory() = /cache      [ 内置SD卡下载缓存文件 ]
    getExternalStorageDirectory() = /storage/emulated/0      [ 内置SD卡根目录 ]
    getSdcardPictures("AAAA") = /storage/emulated/0/AAAA      [ 内置SD卡根目录下当文件夹/文件 ]
    getExternalStorageState() = mounted      [ 内置SD卡运行状态 ]
    isExternalStorageEmulated() = true      [ true：是虚拟当内置SD卡 ]
    isExternalStorageRemovable() = false      [ true：SD置卡可以卸载；false：不可以移动 ]

    -------------------------------------------------------应用级----------------------------------------------------

    deleteFile(context,"AAAA") = false      [ true:删除文件/文件夹成功；false：删除文件/文件夹失败 ]
    deleteDatabase(context,"AAAA") = false      [ true:删除数据库.db文件成功；false：删除数据库.db文件失败 ]
    deleteSharedPreferences(context,"AAAA") = true      [ ？:删除成功；？：删除失败 ]
    getDataDir(context) = /data/user/0/com.rmbmiss.app.mian     [ API >= 24 内存储 ]
    getDir(context,"AAAA",0) = /data/user/0/com.rmbmiss.app.mian/app_AAAA      [ 内存储 ]
    getFileStreamPath(context,"AAAA") = /data/user/0/com.rmbmiss.app.mian/files/AAAA      [ 内存储 ]
    getCodeCacheDir(context) = /data/user/0/com.rmbmiss.app.mian/code_cache      [ 内存储 ]
    getNoBackupFilesDir(context) = /data/user/0/com.rmbmiss.app.mian/no_backup      [ 内存储 ]
    getObbDir(context) = /storage/emulated/0/Android/obb/com.rmbmiss.app.mian      [ 内置SD卡 ]
    getExternalFilesDirs(context,"AAAA") =  /storage/emulated/0/Android/data/com.rmbmiss.app.mian/files/.....      [ 内置SD卡 ]
    getFilesDir(context) = /data/user/0/com.rmbmiss.app.mian/files      [ 内存储 ]
    getCacheDir(context) = /data/user/0/com.rmbmiss.app.mian/cache      [ 内存储 ]
    getExternalFilesDir(context,"AAAA") = /storage/emulated/0/Android/data/com.rmbmiss.app.mian/files/AAAA      [ 内置SD卡 ]
    getExternalCacheDir(context) = /storage/emulated/0/Android/data/com.rmbmiss.app.mian/cache      [ 内置SD卡 ]
    getPackageResourcePath(context) = /data/app/com.rmbmiss.app.mian-2/base.apk      [ 内存储 ]
    getDatabasePath(context,"AAAA") = /data/user/0/com.rmbmiss.app.mian/databases/AAAA      [ 内存储 ]
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

}
