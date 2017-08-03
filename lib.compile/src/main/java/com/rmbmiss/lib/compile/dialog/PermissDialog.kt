package com.rmbmiss.lib.compile.dialog

import android.content.Context
import android.content.DialogInterface
import android.support.annotation.StringRes
import com.yanzhenjie.alertdialog.AlertDialog
import com.yanzhenjie.permission.R
import com.yanzhenjie.permission.SettingService

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/8/2$ 14:50$
 * 修 改 人：IMissYou$
 * 修改时间：2017/8/2$ 14:50$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class PermissDialog(context: Context, settingService: SettingService) {

    private val mBuilder: AlertDialog.Builder
    private val mSettingService: SettingService
    private val mClickListener = ClickListener()

     init {
        mBuilder = AlertDialog.newBuilder(context)
                .setCancelable(false)
                .setTitle(R.string.permission_title_permission_failed)
                .setMessage(R.string.permission_message_permission_failed)
                .setPositiveButton(R.string.permission_setting, mClickListener)
                .setNegativeButton(R.string.permission_cancel, mClickListener)
        this.mSettingService = settingService
    }

    fun setTitle(title: String): PermissDialog {
        mBuilder.setTitle(title)
        return this
    }

    fun setTitle(@StringRes title: Int): PermissDialog {
        mBuilder.setTitle(title)
        return this
    }

    fun setMessage(message: String): PermissDialog {
        mBuilder.setMessage(message)
        return this
    }

    fun setMessage(@StringRes message: Int): PermissDialog {
        mBuilder.setMessage(message)
        return this
    }

    fun setNegativeButton(text: String, negativeListener: DialogInterface.OnClickListener?): PermissDialog {
        mBuilder.setNegativeButton(text, negativeListener)
        return this
    }

    fun setNegativeButton(@StringRes text: Int, negativeListener: DialogInterface.OnClickListener?): PermissDialog {
        mBuilder.setNegativeButton(text, negativeListener)
        return this
    }

    fun setPositiveButton(text: String): PermissDialog {
        mBuilder.setPositiveButton(text, mClickListener)
        return this
    }

    fun setPositiveButton(@StringRes text: Int): PermissDialog {
        mBuilder.setPositiveButton(text, mClickListener)
        return this
    }

    fun show() {
        mBuilder.show()
    }

    inner class ClickListener : DialogInterface.OnClickListener{
        override fun onClick(p0: DialogInterface?, p1: Int) {
            when (p1) {
                DialogInterface.BUTTON_NEGATIVE -> mSettingService.cancel()
                DialogInterface.BUTTON_POSITIVE -> mSettingService.execute()
            }
        }

    }
}