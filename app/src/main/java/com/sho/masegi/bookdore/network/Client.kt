package com.sho.masegi.bookdore.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object Client {

    fun retrofit(baseUrl: String): Retrofit {
        val moshi = Moshi.Builder()
                         .add(KotlinJsonAdapterFactory())
                         .build()
        return Retrofit.Builder()
                       .baseUrl(baseUrl)
                       .addConverterFactory(MoshiConverterFactory.create(moshi))
                       .build()
    }

    fun httpClient(): HttpClient {
        return HttpClient(OkHttp) {
            engine {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
                addInterceptor(loggingInterceptor)
            }
            install(JsonFeature) {
                serializer = GsonSerializer()
            }
        }
    }
}
