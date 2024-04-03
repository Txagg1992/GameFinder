package com.curiousapps.gamefinder.data.mapper

import com.curiousapps.gamefinder.data.local.GameListingEntity
import com.curiousapps.gamefinder.domain.model.GameListing

fun GameListingEntity.toGameListing(): GameListing{
    return GameListing(
        aliases = aliases,
        deck = deck,
        description = description,
    )
}

fun GameListing.toGameListingEntity(): GameListingEntity{
    return GameListingEntity(
        aliases = aliases,
        deck = deck,
        description = description,
    )
}