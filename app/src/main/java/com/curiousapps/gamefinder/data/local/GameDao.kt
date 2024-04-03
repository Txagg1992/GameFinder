package com.curiousapps.gamefinder.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGamesList(gamesList: List<GameListingEntity>)

    @Query("DELETE FROM gamelistingentity")
    suspend fun clearGamesList()

    @Query(
        """
            SELECT *
            FROM gamelistingentity
            WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%'
        """
    )
    suspend fun searchGameList(query: String): List<GameListingEntity>
}