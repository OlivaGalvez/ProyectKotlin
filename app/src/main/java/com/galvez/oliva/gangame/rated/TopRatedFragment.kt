package com.galvez.oliva.gangame.rated

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import com.galvez.oliva.commons.BR
import com.galvez.oliva.commons.BaseFragment
import com.galvez.oliva.commons.BaseListFragment
import com.galvez.oliva.commons.DataBindingRecyclerAdapter
import com.galvez.oliva.gangame.R
import com.galvez.oliva.gangame.TopGame
import com.galvez.oliva.gangame.data.GangameDataSource

/**
 * Created by Oliva on 14/06/2018.
 */

class TopRatedFragment : BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame,
                R.layout.item_top_game)
    }

    override fun onResume() {
        super.onResume()
        showMostOwned()
    }

    private fun showMostOwned() {
        GangameDataSource.getMostOwned()
                .subscribe({list ->
                    replaceItems(list)
                }, {error ->
                    showError(error)
                })
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
    }

    private fun replaceItems (list: List<TopGame>) {
        with(listAdapter as DataBindingRecyclerAdapter<TopGame>) {
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }
}
