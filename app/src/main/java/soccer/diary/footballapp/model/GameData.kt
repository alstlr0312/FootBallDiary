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

