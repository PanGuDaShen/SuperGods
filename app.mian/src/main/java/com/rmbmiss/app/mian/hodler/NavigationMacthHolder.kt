package com.rmbmiss.app.mian.hodler

import android.content.Context
import android.view.View
import com.rmbmiss.app.mian.base.BaseAbstartViewHolder
import com.rmbmiss.app.mian.databean.NavigationDatabean

/**
 * Created by Administrator on 2017/7/25.
 */
class NavigationMacthHolder<T>(content: Context, view: View): BaseAbstartViewHolder<T>(view) {
    override fun bindHolder(person: T) {
        person as NavigationDatabean<String, Any?>
    }
}