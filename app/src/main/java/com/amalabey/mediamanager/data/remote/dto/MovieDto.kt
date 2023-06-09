package com.amalabey.mediamanager.data.remote.dto

import com.amalabey.mediamanager.domain.model.Media
import com.amalabey.mediamanager.domain.model.MediaType

data class MovieDto(
    val added: String,
    val alternateTitles: List<AlternateTitle>,
    val certification: String,
    val cleanTitle: String,
    val collection: Collection,
    val digitalRelease: String,
    val folder: String,
    val folderName: String,
    val genres: List<String>,
    val hasFile: Boolean,
    val images: List<Image>,
    val imdbId: String,
    val inCinemas: String,
    val isAvailable: Boolean,
    val minimumAvailability: String,
    val monitored: Boolean,
    val originalTitle: String,
    val overview: String,
    val physicalRelease: String,
    val qualityProfileId: Int,
    val ratings: Ratings,
    val remotePoster: String,
    val runtime: Int,
    val secondaryYearSourceId: Int,
    val sizeOnDisk: Int,
    val sortTitle: String,
    val status: String,
    val studio: String,
    val tags: List<Any>,
    val title: String,
    val titleSlug: String,
    val tmdbId: Int,
    val website: String,
    val year: Int,
    val youTubeTrailerId: String
)

fun MovieDto.toMedia(): Media {
    return Media(
        type = MediaType.MOVIE,
        title = title,
        description = overview,
        year = year,
        rating = certification,
        runtime = runtime,
        imdbRating = ratings.imdb?.value ?: 0.0,
        rottenTomatoRating = ratings.rottenTomatoes?.value ?: 0,
        genres = genres,
        isDownloaded = isAvailable
    )
}