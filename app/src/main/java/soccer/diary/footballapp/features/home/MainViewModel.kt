import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unity.mynativeapp.network.RetrofitClient
import kotlinx.coroutines.launch
import soccer.diary.footballapp.model.FixturesResponse

class MainViewModel : ViewModel() {
    val fixturesResponse: MutableLiveData<FixturesResponse> = MutableLiveData()

    fun getFixtures(league: Int, season: Int, fromDate: String, toDate: String) {
        viewModelScope.launch {
            val response = RetrofitClient.apiService.getFixtures(league, season, fromDate, toDate)
            if (response.isSuccessful) {
                fixturesResponse.postValue(response.body())
            }
        }
    }
}
