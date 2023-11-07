package soccer.diary.footballapp

import android.app.Application

class MyApplication: Application() {

    companion object {
        var leaguePartHashMap = HashMap<String, Int>()

    }
    override fun onCreate() {
        leaguePartHashMap[getString(R.string.Primier)] = 39
        leaguePartHashMap[getString(R.string.Champions)] = 2
        leaguePartHashMap[getString(R.string.Friendlies)] = 10
        leaguePartHashMap[getString(R.string.K_league)] = 292
        leaguePartHashMap[getString(R.string.Laliga)] = 140
        leaguePartHashMap[getString(R.string.Serie_A)] =  135
        leaguePartHashMap[getString(R.string.Bunleague)] = 78
        leaguePartHashMap[getString(R.string.Ligue_1)] = 61
        super.onCreate()
    }
}