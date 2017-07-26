package com.rmbmiss.lib.utils.apptools

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.os.Build
import android.util.Log
import com.blankj.utilcode.util.LogUtils
import com.rmbmiss.lib.utils.lnstancetools.NoClassNullExt
import java.util.Stack

/**
 * Activity管理类，用于程序页面的销毁和App退出
 * Created by IMissYou on 2016/4/1.
 */
class AppManagerUtils {

    // Activity栈
    private var activityStack: Stack<Activity>? = null

    companion object {
        // 托管单例模式赋值
       private var appManager : AppManagerUtils by NoClassNullExt.noNullClassObject<AppManagerUtils>()
        // 获取对象
        fun getInstance(): AppManagerUtils {
            if (appManager == null){
                appManager = AppManagerUtils()
            }
            return appManager
        }
    }

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        if (activityStack == null) {
            activityStack = Stack<Activity>()
        }
        activityStack?.let {
            it.add(activity)
        }
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity? {
        var activity:Activity?=null
        activityStack?.let {
            activity = it.lastElement()
        }
        return activity
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishActivity() {
        activityStack?.let {
            val activity = it.lastElement()
            finishActivity(activity)
        }
    }

    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity?) {
        activityStack?.let {
            if (activity != null) {
                it.remove(activity)
                activity.finish()
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        activityStack?.let {
            for (activity in it) {
                if (activity.javaClass == cls) {
                    finishActivity(activity)
                }
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishNameActivity(cls: String) {
        activityStack?.let {
            for (activity in it) {
                if (activity.javaClass.name == cls) {
                    finishActivity(activity)
                }
            }
        }
    }

    /**
     * 获取指定类名的对象是否纯在
     * @param cls
     * *
     * @return
     */
    fun getThisActivity(cls: String): Boolean {
        activityStack?.let {
            for (activity in it) {
                if (activity.javaClass.name == cls) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * 清除指定类名外的所有对象
     * @param cls
     */
    fun finishClassActivity(cls: String) {
        activityStack?.let {
            for (activity in it) {
                if (activity.javaClass.name != cls) {
                    finishActivity(activity)
                }
            }
        }
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        activityStack?.let {
            for (i in it.indices) {
                if (null != it[i]) {
                    it[i].finish()
                }
            }
            it.clear()
        }
    }

    /**
     * 退出应用程序
     */
    fun AppExit(context: Context) {
        try {
            finishAllActivity()
            val activityMgr = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            activityMgr.killBackgroundProcesses(context.packageName)
            System.exit(0)
            android.os.Process.killProcess(android.os.Process.myPid())
        } catch (e: Exception) {
            LogUtils.e("APP异常退出")
        } finally {
            System.exit(0)
            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }

    /**
     * 判断app是否后台前台运行
     * @param context
     * *
     * @return
     */
    private fun isAppIsInBackground(context: Context): Boolean {
        var isInBackground = true
        val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            val runningProcesses = am.runningAppProcesses
            for (processInfo in runningProcesses) {
                if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    for (activeProcess in processInfo.pkgList) {
                        if (activeProcess == context.packageName) {
                            isInBackground = false
                        }
                    }
                }
            }
        } else {
            val taskInfo = am.getRunningTasks(1)
            val componentInfo = taskInfo[0].topActivity
            if (componentInfo.packageName == context.packageName) {
                isInBackground = false
            }
        }

        return isInBackground
    }

}
