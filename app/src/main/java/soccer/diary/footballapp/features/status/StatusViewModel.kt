package soccer.diary.footballapp.features.status

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unity.mynativeapp.network.RetrofitClient
import kotlinx.coroutines.launch
import soccer.diary.footballapp.model.StatusResponse

class StatusViewModel : ViewModel() {

    val statusResponse: MutableLiveData<StatusResponse> = MutableLiveData()
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading
    fun status(id: Int) {
        _loading.postValue(true)
        viewModelScope.launch {
            val response = RetrofitClient.apiService.getStatus(id)
            if (response.isSuccessful) {
                _loading.postValue(false)
                statusResponse.value = response.body()
            }
        }
    }


}