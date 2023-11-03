package com.unity.mynativeapp.network


import android.util.Log
import androidx.constraintlayout.widget.StateSet.TAG
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONException
import org.json.JSONObject
import java.util.*

object RetrofitClient{

    private val RAPIDAPI_KEY = "f025adefbemsh766b45786eeb4d1p1c1965jsn15a96dfa4752"
    private val RAPIDAPI_TRUEWAY_PLACES_HOST = "api-football-v1.p.rapidapi.com"

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

    fun getfixtures(h2h: String, league:Int, season:Int, callback: Callback) {
        getRapidApiAsync(
            String.format(Locale.US, "https://%s/v3/fixtures/headtohead?h2h=%s&league=%d&season=%d", RAPIDAPI_TRUEWAY_PLACES_HOST, h2h, league,season),
            RAPIDAPI_KEY,
            RAPIDAPI_TRUEWAY_PLACES_HOST,
            callback
        )
    }

    fun showResults(responseStr: String) {
        try {
            val jsonObj = JSONObject(responseStr)
            val results = jsonObj.getJSONArray("get")
            Log.d(TAG, "found places: " + results.length())
            // looping through All Results
            for (i in 0 until results.length()) {
                val result = results.getJSONObject(i)
                val id = result.getString("parameters")
                val name = result.getString("errors")
                val address = result.getString("results")
                val location = result.getJSONObject("paging")
                val lat = location.getDouble("response")

                Log.d(TAG, String.format(Locale.US, "result[%s]: id=%s; name=%s; address=%s; lat=%.6f;", i, id, name, address, lat))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

}