package soccer.diary.footballapp.features.LeagueDiary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.unity.mynativeapp.network.RetrofitClient
import soccer.diary.footballapp.model.ResponseObserver
import soccer.diary.footballapp.model.FixturesResponse
import java.io.IOException
import java.util.*

class LeagueViewModel : ViewModel() {

    fun fixtures(league:Int, season:Int, fromDate: String, toDate: String, observer: ResponseObserver){
        RetrofitClient.getfixtures(league,season,fromDate,toDate, object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                Log.d("error","error")
            }
            @Throws(IOException::class)
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                if (response.isSuccessful) {
                    Log.d("responseStr","responseStr")
                    val responseStr = response.body?.string()
                    val data = Gson().fromJson(responseStr, FixturesResponse::class.java)
                    observer.onFixturesResponseReceived(data)
                } else {
                    observer.onFixturesResponseError()
                }
            }
        })

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }



}