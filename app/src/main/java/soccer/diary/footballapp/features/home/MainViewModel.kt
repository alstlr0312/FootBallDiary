package soccer.diary.footballapp.features.home

import android.content.ContentValues
import android.util.Log
import androidx.constraintlayout.widget.StateSet
import androidx.constraintlayout.widget.StateSet.TAG
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.unity.mynativeapp.network.RetrofitClient
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import soccer.diary.footballapp.model.FixturesResponse
import java.io.IOException
import java.util.*

class MainViewModel : ViewModel() {
    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> = _toastMessage

    private val _fixtureData = MutableLiveData<FixturesResponse?>()
    val fixtureData: LiveData<FixturesResponse?> = _fixtureData
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