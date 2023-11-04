package com.unity.mynativeapp.network


import android.util.Log
import androidx.constraintlayout.widget.StateSet.TAG
import com.google.gson.Gson
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONException
import org.json.JSONObject
import soccer.diary.footballapp.model.FixturesResponse
import java.util.*

object RetrofitClient{

    val RAPIDAPI_KEY = "f025adefbemsh766b45786eeb4d1p1c1965jsn15a96dfa4752"
    val RAPIDAPI_TRUEWAY_PLACES_HOST = "api-football-v1.p.rapidapi.com"

    private val client = OkHttpClient()

    fun getRapidApiAsync(url: String, rapidApiKey: String, rapidApiHost: String, callback: Callback) {
        val request = Request.Builder()
            .url(url)
            .get()
            .addHeader("x-rapidapi-key", rapidApiKey)
            .addHeader("x-rapidapi-host", rapidApiHost)
            .build()
        val call = client.newCall(request)
        call.enqueue(callback)
    }

    fun getfixtures(h2h: String, league:Int, season:Int, callback: okhttp3.Callback) {
        RetrofitClient.getRapidApiAsync(
            String.format(Locale.US, "https://%s/v3/fixtures/headtohead?h2h=%s&league=%d&season=%d", RAPIDAPI_TRUEWAY_PLACES_HOST, h2h, league, season),
            RetrofitClient.RAPIDAPI_KEY,
            RetrofitClient.RAPIDAPI_TRUEWAY_PLACES_HOST,
            callback
        )

    }


}