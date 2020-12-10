package pt.atp.bobi.data.model

import com.squareup.moshi.Json

data class Breed(
    @Json(name = "bred_for")
    val bred_for: String,
    @Json(name = "breed_group")
    val breed_group: String,
    @Json(name = "height")
    val height: Height,
    @Json(name = "id")
    val id: Int,
    @Json(name = "life_span")
    val life_span: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "origin")
    val origin: String,
    @Json(name = "temperament")
    val temperament: String,
    @Json(name = "weight")
    val weight: Weight
)