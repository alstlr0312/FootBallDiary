package soccer.diary.footballapp.model

interface ResponseObserver {
    fun onFixturesResponseReceived(fixturesResponse: FixturesResponse)

    fun onFixturesResponseError()
}
interface StatusResponseObserver {
    fun onStatusResponseReceived(statusResponse: StatusResponse)
}
interface onBackPressedListener {
    fun onBackPressed()
}