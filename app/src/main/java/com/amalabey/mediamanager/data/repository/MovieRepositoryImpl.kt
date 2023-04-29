package com.amalabey.mediamanager.data.repository

import com.amalabey.mediamanager.data.remote.RadarrApi
import com.amalabey.mediamanager.data.remote.dto.toMedia
import com.amalabey.mediamanager.domain.model.Media
import com.amalabey.mediamanager.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val radarrApi: RadarrApi
): MovieRepository {
    override suspend fun getMovies(keyword: String): List<Media> {
        return radarrApi.getMovies(keyword).map { it -> it.toMedia() }
    }
}