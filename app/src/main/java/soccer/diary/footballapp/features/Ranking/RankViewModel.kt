package soccer.diary.footballapp.features.Ranking


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unity.mynativeapp.network.RetrofitClient
import kotlinx.coroutines.launch
import soccer.diary.footballapp.model.RankingResponse

class RankViewModel : ViewModel() {

    val RankResponse: MutableLiveData<RankingResponse> = MutableLiveData()

    fun getRank(season: Int, league: Int) {
        viewModelScope.launch {
            val response = RetrofitClient.apiService.getRank(season, league)
            if (response.isSuccessful) {
                RankResponse.postValue(response.body())
            }
        }
    }

}
