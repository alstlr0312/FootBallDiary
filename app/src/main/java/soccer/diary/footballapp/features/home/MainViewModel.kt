import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unity.mynativeapp.network.RetrofitClient
import kotlinx.coroutines.launch
import soccer.diary.footballapp.features.LoadingDialog
import soccer.diary.footballapp.model.FixturesResponse

class MainViewModel : ViewModel() {
    val fixturesResponse: MutableLiveData<FixturesResponse> = MutableLiveData()
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading
    fun getFixtures(league: Int, season: Int, fromDate: String, toDate: String) {
        _loading.postValue(true)
        viewModelScope.launch {
            val response = RetrofitClient.apiService.getFixtures(league, season, fromDate, toDate)
            if (response.isSuccessful) {
                _loading.postValue(false)
                fixturesResponse.postValue(response.body())
            }
        }
    }
}
