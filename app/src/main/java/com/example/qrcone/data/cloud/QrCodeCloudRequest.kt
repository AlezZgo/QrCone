package com.example.qrcone.data.cloud

import com.google.gson.annotations.SerializedName
import okhttp3.MediaType
import okhttp3.RequestBody
import okio.BufferedSink
import retrofit2.http.Part
import java.util.*

data class QrCodeCloudRequest (
    @SerializedName("colored")
    val colored: Boolean,
    @SerializedName("content")
    val content: String
)