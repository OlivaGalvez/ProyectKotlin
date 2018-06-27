package com.galvez.oliva.gangame.deals

import android.database.Observable
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.galvez.oliva.commons.BR
import com.galvez.oliva.commons.BaseFragment
import com.galvez.oliva.commons.BaseListFragment
import com.galvez.oliva.commons.DataBindingRecyclerAdapter
import com.galvez.oliva.gangame.Deal
import com.galvez.oliva.gangame.R
import com.galvez.oliva.gangame.data.GangameDataSource
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscriber


/**
 * Created by Oliva on 14/06/2018.
 */

class DealsFragment : BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
       return DataBindingRecyclerAdapter<Deal>(BR.deal,
               R.layout.item_deal)
    }

    override fun onResume() {
        super.onResume()
        showDeals()
    }

    private fun showDeals() {
        GangameDataSource.getDeals()
                .subscribe({list ->
                    replaceItems(list)
                }, {error ->
                    showError(error)
                })
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
    }

    private fun replaceItems (list: List<Deal>) {
        with(listAdapter as DataBindingRecyclerAdapter<Deal>) {
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }
}
