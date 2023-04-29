package com.amalabey.mediamanager.domain.repository

import com.amalabey.mediamanager.domain.model.Media

interface MovieRepository {
    suspend fun getMovies(keyword: String): List<Media>
}