package com.amalabey.mediamanager.data.remote

import com.amalabey.mediamanager.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RadarrApi {
    @GET("/api/v3/movie/lookup")
    suspend fun getMovies(@Query("term") keyword: String): List<MovieDto>
}