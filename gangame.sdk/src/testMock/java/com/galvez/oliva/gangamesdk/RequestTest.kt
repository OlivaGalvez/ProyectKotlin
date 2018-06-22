package com.galvez.oliva.gangamesdk

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonElement
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
                
            }
        }
    }
}