package pt.atp.bobi.data.model

import com.squareup.moshi.Json

data class Height(
    @Json(name = "imperial")
    val imperial: String,
    @Json(name = "metric")
    val metric: String
)