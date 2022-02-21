package com.example.qrcone.data.cloud

import java.util.*

interface CloudDataSource {

    suspend fun createQrCode(
        type: Int,
        colored: Boolean,
        content: String,
        media: String,
    ): String

    class Base(private val service: QrConeApiService) : CloudDataSource{
        override suspend fun createQrCode(
            type: Int,
            colored: Boolean,
            content: String,
            media: String,
        ): String {
//            return service.generateQrCode(type,colored,content,media)
            return ""
        }
    }
}