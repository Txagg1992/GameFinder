package com.curiousapps.gamefinder.data.repository

import com.curiousapps.gamefinder.data.local.GameDatabase
import com.curiousapps.gamefinder.data.mapper.toGameListing
import com.curiousapps.gamefinder.data.remote.GameApi
import com.curiousapps.gamefinder.domain.model.GameListing
import com.curiousapps.gamefinder.domain.repository.GameRepository
import com.curiousapps.gamefinder.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepositoryImpl @Inject constructor(
    val api: GameApi,
    private val database: GameDatabase
): GameRepository {

    private val dao = database.dao
    override suspend fun getGameListing(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<GameListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchGameList(query)

            emit(Resource.Success(
                data = localListings.map { it.toGameListing() }
            ))

            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldLoadFromCache){
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListing = try {
                val response = api.getGames()
            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("Could not load data"))
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("Could not load data from API"))
            }
        }
    }
}