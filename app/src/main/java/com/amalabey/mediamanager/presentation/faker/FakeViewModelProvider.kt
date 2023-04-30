package com.amalabey.mediamanager.presentation.faker

import com.amalabey.mediamanager.domain.model.Media
import com.amalabey.mediamanager.domain.model.MediaType
import com.amalabey.mediamanager.domain.repository.MovieRepository
import com.amalabey.mediamanager.domain.use_case.search_media.SearchMediaUseCase
import com.amalabey.mediamanager.presentation.search_media.SearchMediaViewModel

object FakeViewModelProvider {
    fun provideSearchMediaViewModel() = SearchMediaViewModel(SearchMediaUseCase(fakeMovieRepository))

    private val fakeMovieRepository = object : MovieRepository {
        override suspend fun getMovies(keyword: String): List<Media> {
            return listOf(
                Media(type = MediaType.MOVIE,
                    title = "Terminator 3",
                    description = "3rd Terminator Movie",
                    year = 2003,
                    rating = "R",
                    runtime = 120,
                    imdbRating = 2.3,
                    rottenTomatoRating = 50,
                    genres = listOf("Action", "Sci-fi"),
                    isDownloaded = false
                ),
                Media(type = MediaType.MOVIE,
                    title = "Transformers 1",
                    description = "First transformers movie",
                    year = 2008,
                    rating = "R",
                    runtime = 120,
                    imdbRating = 2.3,
                    rottenTomatoRating = 50,
                    genres = listOf("Action", "Sci-fi"),
                    isDownloaded = false
                ),
            )
        }
    }
}