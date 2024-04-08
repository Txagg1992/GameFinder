package com.curiousapps.gamefinder.domain.repository

import com.curiousapps.gamefinder.domain.model.GameListing
import com.curiousapps.gamefinder.util.Resource
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    suspend fun getGameListing(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<GameListing>>>
}