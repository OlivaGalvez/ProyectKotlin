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

/**
 * Created by Oliva on 14/06/2018.
 */

class TopRatedFragment : BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame,
                R.layout.item_top_game)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        (listAdapter as DataBindingRecyclerAdapter<TopGame>)
                .items.addAll(getDummyTopGames())
        listAdapter.notifyDataSetChanged()
    }

    fun getDummyTopGames(): ArrayList<TopGame>{
        return arrayListOf(TopGame(title="Counter Strike",
                owners = 123456789,
                publisher = "Valve",
                steamRating = 80,
                price = 9.99F,
                position = 1,
                thumb = "https://images.g2a.com/newlayout/600x351/1x1x0/099f8c52f6de/59e5b37fae653a795a1fbdb2"
        ))
    }
}
