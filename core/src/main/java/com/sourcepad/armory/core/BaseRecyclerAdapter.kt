package com.sourcepad.armory.core

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<VH : RecyclerView.ViewHolder, T> : RecyclerView.Adapter<VH>() {

    var items: List<T> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClicked: ((position: Int) -> Unit)? = null

    override fun getItemCount(): Int = items.size

    fun getItem(position: Int): T = items[position]

}