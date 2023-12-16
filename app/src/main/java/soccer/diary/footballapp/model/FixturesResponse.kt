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
    @SerializedName("id")
    val id: Int,
): Serializable

data class StatusResponse(
    @SerializedName("errors")
    val errors: List<Any>,
    @SerializedName("get")
    val `get`: String,
    @SerializedName("paging")
    val paging: Paging,  // 이 부분은 이미 Serializable이므로 변경이 필요 없음
    @SerializedName("parameters")
    val parameters: Parameters,
    @SerializedName("response")
    val response: List<lineResponse>,
    @SerializedName("results")
    val results: Int
) : Serializable

data class RankingResponse(
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
) : Serializable

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
    val players: List<PlayerXXX>,
    @SerializedName("score")
    val score: Score,
    @SerializedName("statistics")
    val statistics: List<StatisticX>,
    @SerializedName("teams")
    val teams: Teams
): Serializable
data class All(
    @SerializedName("draw")
    val draw: Int,
    @SerializedName("goals")
    val goals: Goals,
    @SerializedName("lose")
    val lose: Int,
    @SerializedName("played")
    val played: Int,
    @SerializedName("win")
    val win: Int
): Serializable
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
): Serializable

data class Standing(
    @SerializedName("all")
    val all: All,
    @SerializedName("away")
    val away: Away,
    @SerializedName("description")
    val description: String,
    @SerializedName("form")
    val form: String,
    @SerializedName("goalsDiff")
    val goalsDiff: Int,
    @SerializedName("group")
    val group: String,
    @SerializedName("home")
    val home: Home,
    @SerializedName("points")
    val points: Int,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("team")
    val team: Team,
    @SerializedName("update")
    val update: String
): Serializable
data class Away(
    @SerializedName("draw")
    val draw: Int,
    @SerializedName("goals")
    val goals: Goals,
    @SerializedName("lose")
    val lose: Int,
    @SerializedName("played")
    val played: Int,
    @SerializedName("win")
    val win: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("winner")
    val winner: Boolean
): Serializable

data class Extratime(
    @SerializedName("away")
    val away: Any,
    @SerializedName("home")
    val home: Any
): Serializable
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
): Serializable
data class Fulltime(
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
): Serializable
data class Goals(
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
): Serializable
data class Halftime(
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
): Serializable
data class Home(
    @SerializedName("draw")
    val draw: Int,
    @SerializedName("goals")
    val goals: Goals,
    @SerializedName("lose")
    val lose: Int,
    @SerializedName("played")
    val played: Int,
    @SerializedName("win")
    val win: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("winner")
    val winner: Boolean
): Serializable
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
    val season: Int,
    @SerializedName("standings")
    val standings: List<List<Standing>>
): Serializable
data class Paging(
    @SerializedName("current")
    val current: Int,
    @SerializedName("total")
    val total: Int
): Serializable
data class Parameters(
    @SerializedName("h2h")
    val h2h: String
): Serializable
data class Penalty(
    @SerializedName("away")
    val away: Any,
    @SerializedName("home")
    val home: Any
): Serializable
data class Periods(
    @SerializedName("first")
    val first: Int,
    @SerializedName("second")
    val second: Int
): Serializable
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
): Serializable
data class Score(
    @SerializedName("extratime")
    val extratime: Extratime,
    @SerializedName("fulltime")
    val fulltime: Fulltime,
    @SerializedName("halftime")
    val halftime: Halftime,
    @SerializedName("penalty")
    val penalty: Penalty
): Serializable
data class Status(
    @SerializedName("elapsed")
    val elapsed: Int,
    @SerializedName("long")
    val long: String,
    @SerializedName("short")
    val short: String
): Serializable
data class Teams(
    @SerializedName("away")
    val away: Away,
    @SerializedName("home")
    val home: Home
): Serializable
data class Venue(
    @SerializedName("city")
    val city: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
): Serializable
data class Assist(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
): Serializable
data class Cards(
    @SerializedName("red")
    val red: Int,
    @SerializedName("yellow")
    val yellow: Int
): Serializable
data class Coach(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: String
): Serializable
data class Colors(
    @SerializedName("goalkeeper")
    val goalkeeper: Goalkeeper,
    @SerializedName("player")
    val player: PlayerXXX
): Serializable
data class Dribbles(
    @SerializedName("attempts")
    val attempts: Int,
    @SerializedName("past")
    val past: Int,
    @SerializedName("success")
    val success: Int
): Serializable
data class Duels(
    @SerializedName("total")
    val total: Int,
    @SerializedName("won")
    val won: Int
): Serializable
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
): Serializable
data class Fouls(
    @SerializedName("committed")
    val committed: Int,
    @SerializedName("drawn")
    val drawn: Int
): Serializable

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
): Serializable
data class Goalkeeper(
    @SerializedName("border")
    val border: String,
    @SerializedName("number")
    val number: String,
    @SerializedName("primary")
    val primary: String
): Serializable
data class GoalsX(
    @SerializedName("assists")
    val assists: Any,
    @SerializedName("conceded")
    val conceded: Int,
    @SerializedName("saves")
    val saves: Int,
    @SerializedName("total")
    val total: Int
): Serializable
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
): Serializable
data class Passes(
    @SerializedName("accuracy")
    val accuracy: String,
    @SerializedName("key")
    val key: Int,
    @SerializedName("total")
    val total: Int
): Serializable
data class PenaltyX(
    @SerializedName("away")
    val away: Any,
    @SerializedName("home")
    val home: Any
): Serializable
data class Player(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
): Serializable
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
): Serializable
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
): Serializable
data class PlayerXXX(
    @SerializedName("border")
    val border: String,
    @SerializedName("number")
    val number: String,
    @SerializedName("primary")
    val primary: String
): Serializable
data class PlayerXXXX(
    @SerializedName("players")
    val players: List<PlayerXXXXX>,
    @SerializedName("team")
    val team: TeamXX
): Serializable

data class PlayerXXXXX(
    @SerializedName("player")
    val player: PlayerXXXXXX,
    @SerializedName("statistics")
    val statistics: List<Statistic>
): Serializable
data class PlayerXXXXXX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: String
): Serializable
data class Shots(
    @SerializedName("on")
    val on: Int,
    @SerializedName("total")
    val total: Int
): Serializable
data class StartXI(
    @SerializedName("player")
    val player: PlayerX
): Serializable
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
): Serializable
data class StatisticX(
    @SerializedName("statistics")
    val statistics: List<StatisticXX>,
    @SerializedName("team")
    val team: Team
): Serializable
data class StatisticXX(
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: Any
): Serializable
data class Substitute(
    @SerializedName("player")
    val player: PlayerXX
): Serializable
data class Tackles(
    @SerializedName("blocks")
    val blocks: Int,
    @SerializedName("interceptions")
    val interceptions: Int,
    @SerializedName("total")
    val total: Int
): Serializable
data class Team(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String
): Serializable
data class TeamX(
    @SerializedName("colors")
    val colors: Colors,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String
): Serializable
data class TeamXX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("update")
    val update: String
): Serializable
data class Time(
    @SerializedName("elapsed")
    val elapsed: Int,
    @SerializedName("extra")
    val extra: Any
): Serializable