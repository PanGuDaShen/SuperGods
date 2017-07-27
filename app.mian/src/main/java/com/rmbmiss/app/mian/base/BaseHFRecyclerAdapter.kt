package com.rmbmiss.app.mian.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blankj.utilcode.util.LogUtils

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：RecyclerView万能适配器【继承基类】，T为封装的数据类型，根据传入的参数决定具体类型。
 * 创 建 人：IMissYou
 * 创建时间：2017/5/31 17:42
 * 修 改 人：IMissYou
 * 修改时间：2017/5/31 17:42
 * 修改备注：
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
abstract class BaseHFRecyclerAdapter<T, VH : BaseHFAbstartViewHolder<T>>(that: Context, datas: MutableList<T>?) : RecyclerView.Adapter<VH>() {

    val VIEW_HEADER = -1  //说明是带有Header的
    val VIEW_FOOTER = -2  //说明是带有Footer的
    val VIEW_NORMAL = -3  //说明是不带有header和footer的

    protected var mContext: Context
    protected var mDatas: MutableList<T>
    protected var mInflater: LayoutInflater

    //HeaderView, FooterView 一般用于广告
    var mHeaderView: View? = null
    var mFooterView: View? = null

    private var mHeaderData: Any? = null
    private var mFooterData: Any? = null

    init {
        this.mContext = that
        mInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if (datas == null) {
            this.mDatas = mutableListOf<T>()
        } else {
            this.mDatas = datas
        }
    }

    /**设置头部，如果取消也可以使用此接口*/
    fun <Rs> setHeaderView(headerView: View?, rs: Rs?) {
        mHeaderView = headerView
        mHeaderData = rs
        notifyItemInserted(0)
    }

    /**设置尾部*/
    fun <Rs> setFooterView(footerView: View?, rs: Rs?) {
        mFooterView = footerView
        mFooterData = rs
        notifyItemInserted(getItemCount() - 1)
    }

    /** 更新数据，替换原有数据  */
    fun updateItems(items: MutableList<T>) {
        mDatas = items
        notifyDataSetChanged()
    }

    /** 插入一条数据  */
    fun addItem(item: T) {
        mDatas.add(0, item)
        if (mHeaderView != null) {
            notifyItemInserted(1)
        }
    }

    /** 插入一条数据  */
    fun addItem(item: T, positions: Int) {
        var position = Math.min(positions, mDatas.size)
        mDatas.add(position, item)
        if (mHeaderView != null) {
            position += 1
        }
        notifyItemInserted(position)
    }

    /** 在列表尾添加一串数据  */
    fun addItems(items: List<T>) {
        var start = mDatas.size
        mDatas.addAll(items)
        if (mHeaderView != null) {
            start += 1
        }
        notifyItemRangeChanged(start, items.size)
    }

    /** 移除一条数据  */
    fun removeItem(position: Int) {
        if (position > mDatas.size - 1) {
            return
        }
        var i = position
        if (mHeaderView != null) {
            i += 1
        }
        mDatas.removeAt(i)
        notifyItemRemoved(i)
    }

    /** 移除一条数据  */
    fun removeItem(item: T) {
        var position = 0
        if (mHeaderView != null) {
            position = 1
        }
        val iterator = mDatas.listIterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            if (next === item) {
                iterator.remove()
                notifyItemRemoved(position)
            }
            position++
        }
    }

    /** 清除所有数据  */
    fun removeAllItems() {
        mDatas.clear()
        notifyDataSetChanged()
    }

    /**
     * 自定义返回类型
     */
    open fun getItemType(position: Int): Int {
        return VIEW_NORMAL
    }

    /**
     * 考虑到不是每个Rv都会有头部，所以设计为可重写方法，有头部显示时调用此方法，子类重写即可。
     */
    open fun onCreateHeaderViewHolder(it: View): VH? {
        return null
    }

    /**
     * 考虑到不是每个Rv都会有尾部，所以设计为可重写方法，有尾部显示时调用此方法，子类重写即可。
     */
    open fun onCreateFooterViewHolder(it: View): VH? {
        return null
    }

    /**
     * 这个显示的item比较多，所以设计成抽象方法。
     */
    abstract fun onCreateHolder(parent: ViewGroup?, viewType: Int): VH?

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH? {
        when (viewType) {
            VIEW_HEADER -> return mHeaderView?.let { onCreateHeaderViewHolder(it) }
            VIEW_FOOTER -> return mFooterView?.let { onCreateFooterViewHolder(it) }
            else -> return onCreateHolder(parent, viewType)
        }
        return onCreateHolder(parent, viewType)
    }

    /**
     * item条目总数，根据头尾部变化。
     */
    override fun getItemCount(): Int {
        if (mHeaderView == null && mFooterView == null) {
            return mDatas.size
        } else if (mHeaderView == null && mFooterView != null) {
            return mDatas.size + 1
        } else if (mHeaderView != null && mFooterView == null) {
            return mDatas.size + 1
        } else {
            return mDatas.size + 2
        }
    }

    /**
     * 重写getItemViewType（）方法，过滤条目的返回类型
     */
    override fun getItemViewType(position: Int): Int {
        var pos = position
        // 第一个加载mHeaderView
        if (mHeaderView != null && position == 0) {
            pos -= 1
            return VIEW_HEADER
        }
        // 倒数第一个加载mFooterView
        if (mFooterView != null && position == itemCount - 1) {
            return VIEW_FOOTER
        }
        return getItemType(pos)
    }

    /**
     * 绑定数据
     */
    override fun onBindViewHolder(holder: VH?, position: Int) {
        if (holder != null) {
            if (getItemViewType(position) == VIEW_HEADER) {
                holder.bindHeader(mHeaderData)
            } else if (getItemViewType(position) == VIEW_FOOTER) {
                holder.bindFooter(mFooterData)
            } else {
                if (mHeaderView != null) {
                    holder.bindHolder(mDatas.get(position - 1))

                } else {
                    holder.bindHolder(mDatas.get(position))
                }
            }
        }
    }
}