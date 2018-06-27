package com.galvez.oliva.gangamesdk.serializer

import android.support.annotation.IntegerRes
import com.galvez.oliva.gangamesdk.TopGame
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

/**
 * Created by Oliva on 22/06/2018.
 */

//Creación de la url para coger la iamgen de cada juego
class TopGameDeserializer: JsonDeserializer<TopGame> {

    companion object {
        const val BASE_IMG_URL = "http://cdn.akamai.steamstatic.com/steam/apps/%s/capsule_sm_120.jpg?t=1488471030"
    }

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): TopGame {
        val gson = Gson()

        val topGame = gson.fromJson(json, TopGame::class.java)

        val jsonGame = json.asJsonObject
        val appId = jsonGame["appid"].asInt.toString()

        val rawRating = jsonGame["score_rank"].asString
        val steamRating = if (rawRating.isEmpty()) 0 else Integer.parseInt(rawRating.trim())

        val thumb = String.format(BASE_IMG_URL, appId)
        topGame.thumb = thumb
        topGame.steamRating = steamRating
        return topGame
    }
}