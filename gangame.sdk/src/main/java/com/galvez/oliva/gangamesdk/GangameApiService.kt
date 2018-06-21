package com.galvez.oliva.gangamesdk

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Oliva on 21/06/2018.
 */
class GangameApiService {

    val apiClient: RetrofitGangameApi

    //Configuración del cliente
    init {
        val apiClientConfig =
                Retrofit.Builder()
                        .baseUrl(Routes.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

        //El create nos guarda la instancia de este cliente
        apiClient = apiClientConfig.create(RetrofitGangameApi::class.java)
    }
}