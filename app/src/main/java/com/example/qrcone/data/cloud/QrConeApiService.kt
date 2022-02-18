package com.example.qrcone.data.cloud

import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import java.util.*


interface QrConeApiService {

    @POST("uploadAttachment")
    fun uploadAttachment(
        type: Int,
        colored: Boolean,
        filePart: Base64
    ): QrCodeCloud

}