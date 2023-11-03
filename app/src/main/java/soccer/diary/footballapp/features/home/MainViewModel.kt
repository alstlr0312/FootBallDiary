package soccer.diary.footballapp.features.home

import android.util.Log
import androidx.constraintlayout.widget.StateSet.TAG
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import com.unity.mynativeapp.network.RetrofitClient
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import soccer.diary.footballapp.model.FixturesResponse

class MainViewModel : ViewModel() {
    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> = _toastMessage

    private val _loading = MutableLiveData<Int>()
    val loading: LiveData<Int> = _loading

    private val _checkSuccess = MutableLiveData<Boolean>(false)
    val checkSuccess: LiveData<Boolean> = _checkSuccess

    fun fixtures(h2h: String, league:Int, season:Int) {

        //postCheckAPI(h2h,league,season)
    }

   /* private fun postCheckAPI(h2h: String, league:Int, season:Int) {
        RetrofitClient.getApiService().getFixtures(h2h,league,season).enqueue(object :
            Callback<FixturesResponse> {
            override fun onResponse(call: Call<FixturesResponse>, response: Response<FixturesResponse>) {
                val code = response.code()
                if (code == 200) {
                    val data = response.body()?.response ?: return
                    Log.d("check", "data: ${data}")
                    Log.d("check", "data: ${code}")
                }else{
                    val body = response.errorBody()?.string()
                }
            }


            override fun onFailure(call: Call<FixturesResponse>, t: Throwable) {
                Log.e(TAG, "Error: ${t.message}")

            }
        })
    }*/
}