package com.sourcepad.armory.webservice

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import javax.inject.Singleton

val webServiceModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        val mediaType = "application/json".toMediaType()
        Retrofit.Builder()
            .addConverterFactory(Json(JsonConfiguration.Stable).asConverterFactory(mediaType))
            .client(get<OkHttpClient>())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }


    //TODO Add token interceptor and Retrofit APIs
}


@Module
@InstallIn(ApplicationComponent::class)
object WebserviceModule {


    @Binds
    @Singleton
    fun provideLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Binds
    @Singleton
    fun provideOkHttp(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Binds
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        val mediaType = "application/json".toMediaType()
        return Retrofit.Builder()
            .addConverterFactory(Json(JsonConfiguration.Stable).asConverterFactory(mediaType))
            .client(httpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }


}