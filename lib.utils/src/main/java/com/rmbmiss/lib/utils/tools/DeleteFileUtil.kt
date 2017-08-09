package com.rmbmiss.lib.utils.tools

import com.blankj.utilcode.util.LogUtils
import java.io.File

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：文件操作
 * 创 建 人：IMissYou$
 * 创建时间：2017/8/9$ 10:53$
 * 修 改 人：IMissYou$
 * 修改时间：2017/8/9$ 10:53$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
object DeleteFileUtil {
    /**
     * 删除文件，可以是文件或文件夹
     * @param fileName
     * *            要删除的文件名
     * *
     * @return 删除成功返回true，否则返回false
     */
    fun delete(fileName: String): Boolean {
        val file = File(fileName)
        if (!file.exists()) {
            LogUtils.e("删除文件失败:" + fileName + "不存在！")
            return false
        } else {
            if (file.isFile())
                return deleteFile(fileName)
            else
                return deleteDirectory(fileName)
        }
    }

    /**
     * 删除单个文件
     * @param fileName
     * *            要删除的文件的文件名
     * *
     * @return 单个文件删除成功返回true，否则返回false
     */
    fun deleteFile(fileName: String): Boolean {
        val file = File(fileName)
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                LogUtils.e("删除单个文件" + fileName + "成功！")
                return true
            } else {
                LogUtils.e("删除单个文件" + fileName + "失败！")
                return false
            }
        } else {
            LogUtils.e("删除单个文件失败：" + fileName + "不存在！")
            return false
        }
    }

    /**
     * 删除目录及目录下的文件
     * @param dir
     * *            要删除的目录的文件路径
     * *
     * @return 目录删除成功返回true，否则返回false
     */
    fun deleteDirectory(dir: String): Boolean {
        var dir = dir
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator
        val dirFile = File(dir)
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            LogUtils.e("删除目录失败：${dir}不存在！")
            return false
        }
        var flag = true
        // 删除文件夹中的所有文件包括子目录
        val files = dirFile.listFiles()
        for (i in files.indices) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = DeleteFileUtil.deleteFile(files[i].getAbsolutePath())
                if (!flag)
                    break
            } else if (files[i].isDirectory()) {
                flag = DeleteFileUtil.deleteDirectory(files[i]
                        .getAbsolutePath())
                if (!flag)
                    break
            }// 删除子目录
        }
        if (!flag) {
            LogUtils.e("删除目录失败！")
            return false
        }
        // 删除当前目录
        if (dirFile.delete()) {
            LogUtils.e("删除目录" + dir + "成功！")
            return true
        } else {
            return false
        }
    }

}