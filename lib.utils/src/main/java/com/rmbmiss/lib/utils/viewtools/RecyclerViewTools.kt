package com.rmbmiss.lib.utils.viewtools

import android.content.Context
import android.support.v7.widget.*
import com.rmbmiss.lib.utils.errortools.ErrorStringTools


/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：
 * 创 建 人：IMissYou$
 * 创建时间：2017/7/21$ 10:57$
 * 修 改 人：IMissYou$
 * 修改时间：2017/7/21$ 10:57$
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
object RecyclerViewTools {

    /**
     * 格子效果
     */
    fun setRvGrid(content:Context,rv:RecyclerView,num: Int,hv:Int):RecyclerView {
        //设置布局管理器，num个item并列
        rv.layoutManager = GridLayoutManager(content, num) as RecyclerView.LayoutManager?
        // 设置Item增加、移除动画
        rv.itemAnimator = DefaultItemAnimator()
        when(hv){
            0 -> {
                // 添加水平分割线
                rv.addItemDecoration(DividerItemDecoration(content, DividerItemDecoration.HORIZONTAL))
            }
            1 -> {
                // 添加竖直分割线
                rv.addItemDecoration(DividerItemDecoration(content, DividerItemDecoration.VERTICAL))
            }
            2 -> {
                // 添加水平分割线
                rv.addItemDecoration(DividerItemDecoration(content, DividerItemDecoration.HORIZONTAL))
                // 添加竖直分割线
                rv.addItemDecoration(DividerItemDecoration(content, DividerItemDecoration.VERTICAL))
            }
        }
        return rv
    }

    /**
     * 单行效果
     */
    fun setRvLinear(content:Context,rv:RecyclerView,hv:Int):RecyclerView {
        if (hv != LinearLayoutManager.VERTICAL && hv != LinearLayoutManager.HORIZONTAL){
            ErrorStringTools.showString(" 请把hv传入的值设置成， LinearLayoutManager.VERTICAL || LinearLayoutManager.HORIZONTAL！")
        }
        //设置布局管理器，num个item并列
        rv.layoutManager = LinearLayoutManager(content,hv,false)
        // 设置Item增加、移除动画
        rv.itemAnimator = DefaultItemAnimator()
        // 添加分割线
        rv.addItemDecoration(SettingItemDecoration(content,hv,1))
        return rv
    }

    /**
     * 格子水平暴瀑流效果
     */
    fun setRvStormHORIZONTAL(content:Context,rv:RecyclerView,num: Int,hv:Int):RecyclerView {
        if (hv != StaggeredGridLayoutManager.VERTICAL && hv != StaggeredGridLayoutManager.HORIZONTAL){
            ErrorStringTools.showString(" 请把hv传入的值设置成， StaggeredGridLayoutManager.VERTICAL || StaggeredGridLayoutManager.HORIZONTAL！")
        }
        //设置布局管理器，num个item并列
        rv.layoutManager = StaggeredGridLayoutManager(num, hv)
        // 设置Item增加、移除动画
        rv.itemAnimator = DefaultItemAnimator()
        when(hv){
            0 -> {
                // 添加水平分割线
                rv.addItemDecoration(DividerItemDecoration(content, DividerItemDecoration.HORIZONTAL))
            }
            1 -> {
                // 添加竖直分割线
                rv.addItemDecoration(DividerItemDecoration(content, DividerItemDecoration.VERTICAL))
            }
            2 -> {
                // 添加水平分割线
                rv.addItemDecoration(DividerItemDecoration(content, DividerItemDecoration.HORIZONTAL))
                // 添加竖直分割线
                rv.addItemDecoration(DividerItemDecoration(content, DividerItemDecoration.VERTICAL))
            }
        }
        return rv
    }


}