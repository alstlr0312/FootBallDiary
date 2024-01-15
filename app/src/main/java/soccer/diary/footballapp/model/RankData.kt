package soccer.diary.footballapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
data class RankStanding(
    val rank: Int,
    val team: Ranks,
    val points: Int,
    val goalsDiff: Int,
    val all: RankStats
)

data class Ranks(
    val id: Int,
    val name: String,
    val logo: String
)

data class RankStats(
    val played: Int,
    val win: Int,
    val draw: Int,
    val lose: Int,
    val goals: RankGoals
)

data class RankGoals(
    val forGoals: Int,
    val againstGoals: Int
)
