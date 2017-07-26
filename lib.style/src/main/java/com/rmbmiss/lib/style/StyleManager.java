package com.rmbmiss.lib.style;

import android.app.Application;

import net.wequick.small.Small;

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：加载系统自定义主题，继承有效
 * 创 建 人：IMissYou
 * 创建时间：2017/7/18 11:35
 * 修 改 人：IMissYou
 * 修改时间：2017/7/18 11:35
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
public class StyleManager extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Small.setWebActivityTheme(R.style.AppTheme);
    }
}
