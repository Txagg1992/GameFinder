package com.curiousapps.gamefinder.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GameListingEntity(
    @PrimaryKey
    val id: Int? = null,
    val aliases: String,
    val deck: String,
    val description: String
)
