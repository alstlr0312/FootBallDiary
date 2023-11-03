package soccer.diary.footballapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import soccer.diary.footballapp.model.FixturesResponse


interface RetrofitService {
	@GET("/headtohead")
	fun getFixtures(
		@Query("h2h") h2h: String,
		@Query("league") league: Int,
		@Query("season") season: Int
	): Call<FixturesResponse>
}