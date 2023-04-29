package com.amalabey.mediamanager.di

import com.amalabey.mediamanager.common.Constants
import com.amalabey.mediamanager.data.remote.RadarrApi
import com.amalabey.mediamanager.data.repository.MovieRepositoryImpl
import com.amalabey.mediamanager.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRadarrApi(): RadarrApi {
        return Retrofit.Builder()
            .baseUrl(Constants.RADARR_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RadarrApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: RadarrApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }
}