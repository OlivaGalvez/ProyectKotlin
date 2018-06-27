package com.galvez.oliva.gangamesdk

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.Call
import kotlin.collections.ArrayList

/**
 * Created by Oliva on 21/06/2018.
 */
interface RetrofitGangameApi {

    @GET(Routes.GET_DEALS)
    fun getDeals(): Call<ArrayList<Deal>>

    @GET(Routes.GET_TOP_100_GAMES)
    fun getTopRatedGames(): Call<ArrayList<TopGame>>

    @GET(Routes.GET_MOST_OWNED_GAMES)
    fun getMostOwnedGames(): Call<ArrayList<TopGame>>

    @GET(Routes.GET_DEALS)
    fun getDealsObservable(): Observable<ArrayList<Deal>>

    @GET(Routes.GET_TOP_100_GAMES)
    fun getTopRatedGamesObservable(): Observable<ArrayList<TopGame>>

    @GET(Routes.GET_MOST_OWNED_GAMES)
    fun getMostOwnedGamesObservable(): Observable<ArrayList<TopGame>>
}