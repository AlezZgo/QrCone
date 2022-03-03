package com.example.qrcone.data.cloud

import okhttp3.MultipartBody
import retrofit2.http.*

interface QrConeApiService {

    @Multipart
    @POST("qrgen/")
    suspend fun generate(
        @Header("user_id") id: String,
        @Part filePart: MultipartBody.Part,
        @Query("color") colored: String,
        @Query("content") content: String,
    ): String
}