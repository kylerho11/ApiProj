package com.example.apiproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BallDataService {

    @GET("players")
    fun getPlayersByPage(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,
        @Query("search") search: String): Call<PlayerDataWrapper>

    @GET("season_averages")
    fun getPlayerSeasonAverages(
        @Query("player_ids[]", encoded = true) player_ids: Array<Int>): Call<SeasonAvgWrapper>
}