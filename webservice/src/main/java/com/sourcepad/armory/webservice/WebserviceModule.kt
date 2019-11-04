package com.sourcepad.armory.webservice

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

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