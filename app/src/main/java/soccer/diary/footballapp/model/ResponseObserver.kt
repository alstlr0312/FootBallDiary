package soccer.diary.footballapp.model

import android.content.Context
import soccer.diary.footballapp.model.FixturesResponse

interface ResponseObserver {
    fun onFixturesResponseReceived(fixturesResponse: FixturesResponse)
    fun onFixturesResponseError()
}

interface onBackPressedListener {
    fun onBackPressed()
}