package soccer.diary.footballapp.features.home

import soccer.diary.footballapp.model.FixturesResponse

interface ResponseObserver {
    fun onFixturesResponseReceived(fixturesResponse: FixturesResponse)
    fun onFixturesResponseError()
}