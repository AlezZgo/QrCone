package com.example.qrcone.data.cloud

import com.google.gson.annotations.SerializedName

data class QrCodeCloudRequest(
    @SerializedName("colored")
    val colored: Boolean,
    @SerializedName("content")
    val content: String,
)