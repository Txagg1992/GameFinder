package com.curiousapps.gamefinder.data.remote.dto

import com.squareup.moshi.Json

data class GameDto(
    @field:Json(name = "aliases") val aliases: String?,
)
