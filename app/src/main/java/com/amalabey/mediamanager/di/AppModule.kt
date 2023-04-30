package com.amalabey.mediamanager.di

import com.amalabey.mediamanager.common.Constants
import com.amalabey.mediamanager.data.remote.RadarrApi
import com.amalabey.mediamanager.data.repository.MovieRepositoryImpl
import com.amalabey.mediamanager.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRadarrApi(): RadarrApi {
        val httpClient = createOkHttpClient()
        return Retrofit.Builder()
            .baseUrl(Constants.RADARR_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(RadarrApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: RadarrApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }
}

fun getHeaderInterceptor():Interceptor{
    return Interceptor { chain ->
        val request =
            chain.request().newBuilder()
                .header(Constants.RADARR_API_KEY_HEADER, Constants.RADARR_API_KEY)
                .build()
        chain.proceed(request)
    }
}

private fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(getHeaderInterceptor())
        .build()
}