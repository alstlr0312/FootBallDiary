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