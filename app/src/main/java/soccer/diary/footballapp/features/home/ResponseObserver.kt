package soccer.diary.footballapp.features.home

import android.content.Context
import soccer.diary.footballapp.model.FixturesResponse

interface ResponseObserver {
    fun onFixturesResponseReceived(fixturesResponse: FixturesResponse)
    fun onFixturesResponseError()
}