package soccer.diary.footballapp.features.status

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.unity.mynativeapp.network.RetrofitClient
import soccer.diary.footballapp.model.StatusResponse
import soccer.diary.footballapp.model.StatusResponseObserver
import java.io.IOException
import java.util.*

class StatusViewModel : ViewModel() {

    fun status(id:Int, observer: StatusResponseObserver){
        RetrofitClient.getstatus(id, object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                Log.d("error","error")
            }
            @Throws(IOException::class)
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                if (response.isSuccessful) {
                    val responseStr = response.body?.string()
                    Log.d("responseStr",responseStr.toString())
                    val data = Gson().fromJson(responseStr, StatusResponse::class.java)
                    observer.onStatusResponseReceived(data)
                } else {

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