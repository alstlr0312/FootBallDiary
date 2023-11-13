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
data class StatusResponse(
    @SerializedName("errors")
    val errors: List<Any>,
    @SerializedName("get")
    val `get`: String,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("parameters")
    val parameters: Parameters,
    @SerializedName("response")
    val response: List<Response>,
    @SerializedName("results")
    val results: Int
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
data class Assist(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)
data class Cards(
    @SerializedName("red")
    val red: Int,
    @SerializedName("yellow")
    val yellow: Int
)
data class Coach(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: String
)
data class Colors(
    @SerializedName("goalkeeper")
    val goalkeeper: Goalkeeper,
    @SerializedName("player")
    val player: PlayerXXX
)
data class Dribbles(
    @SerializedName("attempts")
    val attempts: Int,
    @SerializedName("past")
    val past: Int,
    @SerializedName("success")
    val success: Int
)
data class Duels(
    @SerializedName("total")
    val total: Int,
    @SerializedName("won")
    val won: Int
)
data class Event(
    @SerializedName("assist")
    val assist: Assist,
    @SerializedName("comments")
    val comments: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("player")
    val player: Player,
    @SerializedName("team")
    val team: Team,
    @SerializedName("time")
    val time: Time,
    @SerializedName("type")
    val type: String
)
data class Fouls(
    @SerializedName("committed")
    val committed: Int,
    @SerializedName("drawn")
    val drawn: Int
)

data class Games(
    @SerializedName("captain")
    val captain: Boolean,
    @SerializedName("minutes")
    val minutes: Int,
    @SerializedName("number")
    val number: Int,
    @SerializedName("position")
    val position: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("substitute")
    val substitute: Boolean
)
data class Goalkeeper(
    @SerializedName("border")
    val border: String,
    @SerializedName("number")
    val number: String,
    @SerializedName("primary")
    val primary: String
)
data class GoalsX(
    @SerializedName("assists")
    val assists: Any,
    @SerializedName("conceded")
    val conceded: Int,
    @SerializedName("saves")
    val saves: Int,
    @SerializedName("total")
    val total: Int
)
data class Lineup(
    @SerializedName("coach")
    val coach: Coach,
    @SerializedName("formation")
    val formation: String,
    @SerializedName("startXI")
    val startXI: List<StartXI>,
    @SerializedName("substitutes")
    val substitutes: List<Substitute>,
    @SerializedName("team")
    val team: TeamX
)
data class Passes(
    @SerializedName("accuracy")
    val accuracy: String,
    @SerializedName("key")
    val key: Int,
    @SerializedName("total")
    val total: Int
)
data class PenaltyX(
    @SerializedName("away")
    val away: Any,
    @SerializedName("home")
    val home: Any
)
data class Player(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)
data class PlayerX(
    @SerializedName("grid")
    val grid: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("pos")
    val pos: String
)
data class PlayerXX(
    @SerializedName("grid")
    val grid: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("pos")
    val pos: String
)
data class PlayerXXX(
    @SerializedName("border")
    val border: String,
    @SerializedName("number")
    val number: String,
    @SerializedName("primary")
    val primary: String
)
data class PlayerXXXX(
    @SerializedName("players")
    val players: List<PlayerXXXXX>,
    @SerializedName("team")
    val team: TeamXX
)

data class PlayerXXXXX(
    @SerializedName("player")
    val player: PlayerXXXXXX,
    @SerializedName("statistics")
    val statistics: List<Statistic>
)
data class PlayerXXXXXX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: String
)
data class Shots(
    @SerializedName("on")
    val on: Int,
    @SerializedName("total")
    val total: Int
)
data class StartXI(
    @SerializedName("player")
    val player: PlayerX
)
data class Statistic(
    @SerializedName("cards")
    val cards: Cards,
    @SerializedName("dribbles")
    val dribbles: Dribbles,
    @SerializedName("duels")
    val duels: Duels,
    @SerializedName("fouls")
    val fouls: Fouls,
    @SerializedName("games")
    val games: Games,
    @SerializedName("goals")
    val goals: GoalsX,
    @SerializedName("offsides")
    val offsides: Int,
    @SerializedName("passes")
    val passes: Passes,
    @SerializedName("penalty")
    val penalty: Penalty,
    @SerializedName("shots")
    val shots: Shots,
    @SerializedName("tackles")
    val tackles: Tackles
)
data class StatisticX(
    @SerializedName("statistics")
    val statistics: List<StatisticXX>,
    @SerializedName("team")
    val team: Team
)
data class StatisticXX(
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: Int
)
data class Substitute(
    @SerializedName("player")
    val player: PlayerXX
)
data class Tackles(
    @SerializedName("blocks")
    val blocks: Int,
    @SerializedName("interceptions")
    val interceptions: Int,
    @SerializedName("total")
    val total: Int
)
data class Team(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String
)
data class TeamX(
    @SerializedName("colors")
    val colors: Colors,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String
)
data class TeamXX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("update")
    val update: String
)
data class Time(
    @SerializedName("elapsed")
    val elapsed: Int,
    @SerializedName("extra")
    val extra: Any
)