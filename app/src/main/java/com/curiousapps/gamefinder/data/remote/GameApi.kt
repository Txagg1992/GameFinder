package com.curiousapps.gamefinder.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET("games")
    suspend fun getGames(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = FORMAT,
        @Query("filter") name: String
    ): ResponseBody

    companion object{
        const val BASE_URL = "https://www.giantbomb.com/api/"
        const val FORMAT = "json"
        const val API_KEY = "9d45436f87d3848d2bdcce810bacb6df57dfd134"
    }
}