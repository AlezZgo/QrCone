package com.example.qrcone.core

import android.app.Application
import com.example.qrcone.data.cloud.QrConeApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QrConeApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
    fun provideInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()

    fun provideApiService(retrofit: Retrofit): QrConeApiService {
        return retrofit.create(QrConeApiService::class.java)
    }

    fun getApi(): QrConeApiService{
        return provideApiService(provideRetrofit(provideOkHttpClient(provideInterceptor())))
    }

    companion object {
        private const val baseUrl = "https://swapi.dev/"
    }
}