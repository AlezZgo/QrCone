package com.example.qrcone.data.cloud

import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import java.util.*


interface QrConeApiService {

    @POST("uploadAttachment")
    suspend fun generateQrCode(
        type: Int,
        colored: Boolean,
        content: String,
        media: String,
    ): String
}