package soccer.diary.footballapp.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class lineResponse(
    @SerializedName("events")
    val events: List<Event>,
    @SerializedName("fixture")
    val fixture: Fixture,
    @SerializedName("goals")
    val goals: Goals,
    @SerializedName("league")
    val league: League,
    @SerializedName("lineups")
    val lineups: List<Lineup>,
    @SerializedName("players")
    val players: List<PlayerXXXX>,
    @SerializedName("score")
    val score: Score,
    @SerializedName("statistics")
    val statistics: List<StatisticX>,
    @SerializedName("teams")
    val teams: Teams
): Serializable