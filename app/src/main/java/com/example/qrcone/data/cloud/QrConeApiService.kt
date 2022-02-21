package com.example.qrcone.data.cloud

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface QrConeApiService {

    @Multipart
    @POST("files/images/create")
    suspend fun generateQrCode(
        @Body body: QrCodeCloudRequest,
        @Part file: MultipartBody.Part,
    ): ResponseBody
}