package com.example.olxfake.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.LoggingEventListener
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {


    private fun getRetrofit() : Retrofit {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl("http://192.168.56.1:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    }

    fun getEndpoints() : Endpoints{
        return getRetrofit().create(Endpoints::class.java)
    }
}