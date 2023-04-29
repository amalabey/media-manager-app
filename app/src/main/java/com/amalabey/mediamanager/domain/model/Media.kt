package com.amalabey.mediamanager.domain.model

data class Media(
    val type: MediaType,
    val title: String,
    val year: String,
    val rating: String,
    val runtime: Int,
    val imdbRating: Float,
    val rottenTomatoRating: Int,
    val genres: List<String>,
    val isDownloaded: Boolean
)
