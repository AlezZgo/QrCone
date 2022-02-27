package com.example.qrcone.data.cloud

import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface QrConeApiService {

    @Multipart
    @POST("qrgen")
    suspend fun generate(
        @Part filePart: MultipartBody.Part,
        @Query("colored") colored: String,
        @Query("content") content: String,
    ): String
}