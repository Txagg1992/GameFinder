package com.curiousapps.gamefinder.data.remote.dto

import com.squareup.moshi.Json

data class GameDto(
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "deck") val deck: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "medium_url") val mediumImageUrl: String?,
)
