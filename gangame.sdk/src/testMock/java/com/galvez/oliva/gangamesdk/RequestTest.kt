package com.galvez.oliva.gangamesdk

import com.google.gson.JsonArray
import com.google.gson.JsonParser
import org.junit.Assert
import org.junit.Test

/**
 * Created by Oliva on 22/06/2018.
 */
class RequestTest {

    @Test
    fun dealsRequest_success() {
        val apiService = GangameApiService()
        val response = apiService.apiClient.getDeals().execute()
        val deals = response.body()

        val parser = JsonParser()
        val jsonResponse: JsonArray = parser.parse(MockResponses.DEALS_RESPONSE).asJsonArray

        Assert.assertTrue(response.isSuccessful)

        deals?.let{
            Assert.assertEquals(deals?.size, jsonResponse.size())

            deals.zip(jsonResponse).forEach{(deal, jsonDeal) ->
                with(jsonDeal.asJsonObject) {
                    Assert.assertEquals(deal.title, this["title"].asString)
                    Assert.assertEquals(deal.metacriticScore, this["metacriticScore"].asInt)
                    Assert.assertEquals(deal.steamRating, this["steamRatingPercent"].asInt)
                    Assert.assertEquals(deal.thumb, this["thumb"].asString)
                }
            }
        }
    }
    @Test
    fun topRatedRequest_success() {
        val apiService = GangameApiService()
        val response = apiService.apiClient.getTopRatedGames().execute()
        val games = response.body()

        val parser = JsonParser()
        val jsonResponse: JsonArray = parser.parse(MockResponses.TOP_100_GAMES).asJsonArray

        Assert.assertTrue(response.isSuccessful)

        games?.let{
            Assert.assertEquals(games?.size, jsonResponse.size())

            games.zip(jsonResponse).forEach{ (deal, jsonDeal) ->
                with(jsonDeal.asJsonObject) {
                    Assert.assertEquals(deal.title, this["title"].asString)
                    Assert.assertEquals(deal.steamRating, this["score_rank"].asInt)
                    Assert.assertEquals(deal.owners, this["owners"].asString)
                    Assert.assertEquals(deal.publisher, this["publisher"].asInt)
                }
            }
        }
    }
}