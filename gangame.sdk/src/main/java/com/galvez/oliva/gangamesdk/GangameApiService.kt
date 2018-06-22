package com.galvez.oliva.gangamesdk

import com.galvez.oliva.gangamesdk.serializer.TopGameDeserializer
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Oliva on 21/06/2018.
 */
class GangameApiService(val apiConfig: GangameApiConfig = GangameClientConfig()) {

    val apiClient: RetrofitGangameApi

    //Configuración del cliente
    init {
        val gson = GsonBuilder()
                .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .create()

        val apiClientConfig =
                Retrofit.Builder()
                        .baseUrl(Routes.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())

        apiConfig.setupConfig(apiClientConfig)
        //El create nos guarda la instancia de este cliente
        apiClient = apiClientConfig.build().create(RetrofitGangameApi::class.java)
    }
}