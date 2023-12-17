package soccer.diary.footballapp.model

import com.google.gson.annotations.SerializedName

class statusbaritem (
    @SerializedName("statusname")
    val statusname: String,
    @SerializedName("homescore")
    val homescore: Any,
    @SerializedName("awayscore")
    val awayscore: Any,
)
class lineupitem(
    @SerializedName("num")
    val num: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("postion")
    val postion: String,
    @SerializedName("face")
    val face: String,
    @SerializedName("sub")
    val sub: Boolean,
    @SerializedName("statistics")
    val statistics: List<Statistic>
)