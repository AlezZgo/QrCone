package com.example.qrcone.data.cloud

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface QrConeApiService {

    @Multipart
    @POST("qrgen")
    suspend fun generateQrCode(
        @Part description: MultipartBody.Part,
        @Part file: MultipartBody.Part,
    ): Call<ResponseBody>
}