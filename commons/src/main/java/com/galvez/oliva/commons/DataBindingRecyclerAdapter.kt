package com.galvez.oliva.commons

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Oliva on 18/06/2018.
 */
class DataBindingRecyclerAdapter<MODEL>(val itemVariableID: Int,
                                        val itemLayoutResId: Int) : RecyclerView.Adapter<DataBindingViewHolder<MODEL>>() {

    var items = mutableListOf<MODEL>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<MODEL> {
        val binding : ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                itemLayoutResId,
                parent,
                false)
        return DataBindingViewHolder(itemVariableID, binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder<MODEL>, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }
}