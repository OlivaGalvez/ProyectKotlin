package com.galvez.oliva.gangamesdk

import com.google.gson.Gson
import org.junit.Assert
import org.junit.Test

/**
 * Created by Oliva on 21/06/2018.
 */
class ModelUnitTest {

    val JSON_DEAL = "{"+
            "\"internalName\":\"BATMANARKHAMASYLUMGAMEOFTHEYEAREDITION\"," +
            "\"title\":\"Batman: Arkham Asylum Game of the Year Edition\"," +
            "\"metacriticLink\":\"/game/pc/batman-arkham-asylum---game-of-the-year-edition\"," +
            "\"dealID\":\"WmiQczaqtR1czja83xUulOngMhmt1SFdv5lVVA1GUo0%3D\"," +
            "\"storeID\":\"6\"," +
            "\"gameID\":\"146\"," +
            "\"salePrice\":\"19.99\","+
            "\"normalPrice\":\"19.99\"," +
            "\"isOnSale\":\"0\"," +
            "\"savings\":\"0.000000\"," +
            "\"metacriticScore\":\"0\"," +
            "\"steamRatingText\":\"Overwhelmingly Positive\"," +
            "\"steamRatingPercent\":\"95\"," +
            "\"steamRatingCount\":\"10422\"," +
            "\"steamAppID\":\"35140\"," +
            "\"releaseDate\":1269561600," +
            "\"lastChange\":1529305557," +
            "\"dealRating\":\"0.0\"," +
            "\"thumb\":\"https://steamcdn-a.akamaihd.net/steam/apps/35140/capsule_sm_120.jpg?t=1525990900\""+
            "}"

    @Test
    fun dealParsingTest(){
        val gson = Gson()
        val deal = gson.fromJson(JSON_DEAL, Deal::class.java)

        Assert.assertEquals(deal.title, "Batman: Arkham Asylum Game of the Year Edition")
        Assert.assertEquals(deal.metacriticScore, 0)
        Assert.assertEquals(deal.steamRating, 95)
        Assert.assertEquals(deal.salePrice, 19.99F)
        Assert.assertEquals(deal.normalPrice, 19.99F)
        Assert.assertEquals(deal.thumb, "https://steamcdn-a.akamaihd.net/steam/apps/35140/capsule_sm_120.jpg?t=1525990900")
    }

    @Test
    fun topGameParsingTest(){

    }
}