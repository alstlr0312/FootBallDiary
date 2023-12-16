package soccer.diary.footballapp.network



import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import soccer.diary.footballapp.model.FixturesResponse
import soccer.diary.footballapp.model.RankingResponse
import soccer.diary.footballapp.model.StatusResponse

interface ApiService {
    @GET("v3/fixtures")
    suspend fun getFixtures(
        @Query("league") league: Int,
        @Query("season") season: Int,
        @Query("from") from: String,
        @Query("to") to: String
    ): Response<FixturesResponse>

    @GET("v3/fixtures")
    suspend fun getStatus(
        @Query("id") id: Int
    ): Response<StatusResponse>

    @GET("v3/standings")
    suspend fun getRank(
        @Query("season") season: Int,
        @Query("league") league: Int,
    ): Response<RankingResponse>

}