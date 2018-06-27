package com.galvez.oliva.gangame.data

import com.galvez.oliva.gangame.Deal


/**
 * Created by Oliva on 27/06/2018.
 */
object DealMapper {

    fun fromSdk (deal: com.galvez.oliva.gangamesdk.Deal): Deal {
        return Deal(deal.title,
                deal.salePrice,
                deal.normalPrice,
                deal.metacriticScore,
                deal.steamRating,
                deal.thumb)
    }
}