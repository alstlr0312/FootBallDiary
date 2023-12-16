package soccer.diary.footballapp.model

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
