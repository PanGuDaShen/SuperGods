package com.rmbmiss.lib.utils.viewtools

import android.content.Context
import android.support.v7.widget.*


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
    fun setRvGrid(content:Context,rv:RecyclerView,num: Int,suma:Int):RecyclerView {
        //设置布局管理器，num个item并列
        rv.layoutManager = GridLayoutManager(content, num)
        // 设置Item增加、移除动画
        rv.itemAnimator = DefaultItemAnimator()
        when(suma){
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
    fun setRvLinear(content:Context,rv:RecyclerView,suma:Int):RecyclerView {
        //设置布局管理器，num个item并列
        rv.layoutManager = LinearLayoutManager(content)
        // 设置Item增加、移除动画
        rv.itemAnimator = DefaultItemAnimator()
        when(suma){
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
     * 格子水平暴瀑流效果
     */
    fun setRvStormHORIZONTAL(content:Context,rv:RecyclerView,num: Int,suma:Int):RecyclerView {
        //设置布局管理器，num个item并列
        rv.layoutManager = StaggeredGridLayoutManager(num, StaggeredGridLayoutManager.HORIZONTAL)
        // 设置Item增加、移除动画
        rv.itemAnimator = DefaultItemAnimator()
        when(suma){
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
     * 格子竖直暴瀑流效果
     */
    fun setRvStormVERTICAL(content:Context,rv:RecyclerView,num: Int,suma:Int):RecyclerView {
        //设置布局管理器，num个item并列
        rv.layoutManager = StaggeredGridLayoutManager(num, StaggeredGridLayoutManager.VERTICAL)
        // 设置Item增加、移除动画
        rv.itemAnimator = DefaultItemAnimator()
        when(suma){
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