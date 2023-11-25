package com.unity.mynativeapp.network


import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import soccer.diary.footballapp.network.ApiService
import java.util.*

object RetrofitClient{

    val RAPIDAPI_KEY = "f025adefbemsh766b45786eeb4d1p1c1965jsn15a96dfa4752"
    val RAPIDAPI_TRUEWAY_PLACES_HOST = "api-football-v1.p.rapidapi.com"

    private const val BASE_URL = "https://api-football-v1.p.rapidapi.com/"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("x-rapidapi-key", RAPIDAPI_KEY)
                .addHeader("x-rapidapi-host", RAPIDAPI_TRUEWAY_PLACES_HOST)
                .build()
            chain.proceed(newRequest)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}