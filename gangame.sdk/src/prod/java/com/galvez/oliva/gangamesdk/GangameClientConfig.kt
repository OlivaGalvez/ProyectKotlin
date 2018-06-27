package com.galvez.oliva.gangamesdk

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

/**
 * Created by Oliva on 22/06/2018.
 */
class GangameClientConfig: GangameApiConfig {
    override fun setupConfig(builder: Retrofit.Builder) {
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        builder.client(okHttpClient)
    }
}