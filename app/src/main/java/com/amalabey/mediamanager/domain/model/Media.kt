package com.amalabey.mediamanager.domain.model

data class Media(
    val type: MediaType,
    val title: String,
    val description: String?,
    val year: Int,
    val rating: String?,
    val runtime: Int,
    val imdbRating: Double,
    val rottenTomatoRating: Int,
    val genres: List<String>?,
    val isDownloaded: Boolean
)
