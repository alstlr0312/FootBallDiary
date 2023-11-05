package soccer.diary.footballapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class gameItem(
    @SerializedName("homeimg")
    val homeimg: String,
    @SerializedName("homescore")
    val homescore: Int,
    @SerializedName("hometeam")
    val hometeam: String,
    @SerializedName("awayimg")
    val awayimg: String,
    @SerializedName("awayscore")
    val awayscore: Int,
    @SerializedName("awayteam")
    val awayteam: String,
    @SerializedName("startime")
    val startime: String,
)
data class FixturesResponse(
    @SerializedName("errors")
    val errors: List<Any>,
    @SerializedName("get")
    val get: String,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("parameters")
    val parameters: Parameters,
    @SerializedName("response")
    val response: List<Response>,
    @SerializedName("results")
    val results: Int
)

data class Away(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("winner")
    val winner: Boolean
)
data class Extratime(
    @SerializedName("away")
    val away: Any,
    @SerializedName("home")
    val home: Any
)
data class Fixture(
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("periods")
    val periods: Periods,
    @SerializedName("referee")
    val referee: String,
    @SerializedName("status")
    val status: Status,
    @SerializedName("timestamp")
    val timestamp: Int,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("venue")
    val venue: Venue
)
data class Fulltime(
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
)
data class Goals(
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
)
data class Halftime(
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
)
data class Home(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("winner")
    val winner: Boolean
)
data class League(
    @SerializedName("country")
    val country: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("round")
    val round: String,
    @SerializedName("season")
    val season: Int
)
data class Paging(
    @SerializedName("current")
    val current: Int,
    @SerializedName("total")
    val total: Int
)
data class Parameters(
    @SerializedName("h2h")
    val h2h: String
)
data class Penalty(
    @SerializedName("away")
    val away: Any,
    @SerializedName("home")
    val home: Any
)
data class Periods(
    @SerializedName("first")
    val first: Int,
    @SerializedName("second")
    val second: Int
)
data class Response(
    @SerializedName("fixture")
    val fixture: Fixture,
    @SerializedName("goals")
    val goals: Goals,
    @SerializedName("league")
    val league: League,
    @SerializedName("score")
    val score: Score,
    @SerializedName("teams")
    val teams: Teams
)
data class Score(
    @SerializedName("extratime")
    val extratime: Extratime,
    @SerializedName("fulltime")
    val fulltime: Fulltime,
    @SerializedName("halftime")
    val halftime: Halftime,
    @SerializedName("penalty")
    val penalty: Penalty
)
data class Status(
    @SerializedName("elapsed")
    val elapsed: Int,
    @SerializedName("long")
    val long: String,
    @SerializedName("short")
    val short: String
)
data class Teams(
    @SerializedName("away")
    val away: Away,
    @SerializedName("home")
    val home: Home
)
data class Venue(
    @SerializedName("city")
    val city: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)