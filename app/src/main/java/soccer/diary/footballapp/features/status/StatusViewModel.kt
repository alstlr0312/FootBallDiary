package soccer.diary.footballapp.features.status

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.unity.mynativeapp.network.RetrofitClient
import kotlinx.coroutines.launch
import soccer.diary.footballapp.model.StatusResponse
import soccer.diary.footballapp.model.StatusResponseObserver
import java.io.IOException
import java.util.*

class StatusViewModel : ViewModel() {

    val statusResponse: MutableLiveData<StatusResponse> = MutableLiveData()

    fun status(id: Int) {
        viewModelScope.launch {
            val response = RetrofitClient.apiService.getStatus(id)
            if (response.isSuccessful) {
                statusResponse.value = response.body()
            }
        }
    }


}