package com.galvez.oliva.commons

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Oliva on 18/06/2018.
 */
class DataBindingViewHolder<MODEL>(val itemVariableID: Int,
                                   val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindItem (item: MODEL) {
        binding.setVariable(itemVariableID, item)
        binding.executePendingBindings()
    }
}