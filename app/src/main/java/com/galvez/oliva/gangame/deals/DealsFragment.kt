package com.galvez.oliva.gangame.deals

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.galvez.oliva.commons.BR
import com.galvez.oliva.commons.BaseFragment
import com.galvez.oliva.commons.BaseListFragment
import com.galvez.oliva.commons.DataBindingRecyclerAdapter
import com.galvez.oliva.gangame.Deal
import com.galvez.oliva.gangame.R


/**
 * Created by Oliva on 14/06/2018.
 */

class DealsFragment : BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
       return DataBindingRecyclerAdapter<Deal>(BR.deal,
               R.layout.item_deal)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingRecyclerAdapter<Deal>)
                .items.addAll(getDummyDeals())
        listAdapter.notifyDataSetChanged()
    }

    fun getDummyDeals (): ArrayList<Deal> {
        return arrayListOf(Deal ("Counter Strike",
                0.99F,
                9.99F,
                80,
                80,
                "https://images.g2a.com/newlayout/600x351/1x1x0/099f8c52f6de/59e5b37fae653a795a1fbdb2"
        ))
    }
}
