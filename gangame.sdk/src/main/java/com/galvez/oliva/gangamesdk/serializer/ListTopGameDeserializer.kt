package com.galvez.oliva.gangamesdk.serializer

import com.galvez.oliva.gangamesdk.TopGame
import com.google.gson.*
import java.lang.reflect.Type

/**
 * Created by Oliva on 25/06/2018.
 */
class ListTopGameDeserializer: JsonDeserializer<ArrayList<TopGame>>{
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): ArrayList<TopGame> {
        val jsonTopGames =
                json.asJsonObject
                        .entrySet()
                        .map { (key, json) ->
                            json.asJsonObject
                        }
        val gson = GsonBuilder()
                .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .create()

        val listTopGames: List<TopGame> = jsonTopGames.map { json ->
            gson.fromJson(json, TopGame::class.java)
        }
        val arrayListTopGames: ArrayList<TopGame> = arrayListOf()
        arrayListTopGames.addAll(listTopGames)

        return arrayListTopGames
    }
}