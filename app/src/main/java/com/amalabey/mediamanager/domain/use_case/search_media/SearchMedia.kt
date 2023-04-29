package com.amalabey.mediamanager.domain.use_case.search_media

import com.amalabey.mediamanager.common.Resource
import com.amalabey.mediamanager.domain.model.Media
import com.amalabey.mediamanager.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchMedia @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(keyword: String): Flow<Resource<List<Media>>> = flow {
        try {
            emit(Resource.Loading<List<Media>>())
            val mediaResults = repository.getMovies(keyword)
            emit(Resource.Success<List<Media>>(mediaResults))
        }catch (e: HttpException){
            emit(Resource.Error<List<Media>>(e.localizedMessage?: "An unexpected server error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<List<Media>>("Couldn't connect to server. Please check your internet connection"))
        }
    }
}