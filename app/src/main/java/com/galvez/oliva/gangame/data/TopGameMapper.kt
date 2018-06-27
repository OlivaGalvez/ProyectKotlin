package com.galvez.oliva.gangame.data

import com.galvez.oliva.gangame.TopGame

/**
 * Created by Oliva on 27/06/2018.
 */
object TopGameMapper {

    fun fromSdk (topGame: com.galvez.oliva.gangamesdk.TopGame, position: Int): TopGame {
        return TopGame(topGame.title,
                topGame.owners,
                topGame.steamRating,
                topGame.publisher,
                topGame.price,
                position,
                topGame.thumb)
    }
}