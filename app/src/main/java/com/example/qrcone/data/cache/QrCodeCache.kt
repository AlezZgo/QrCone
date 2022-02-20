package com.example.qrcone.data.cache

import com.example.qrcone.core.Abstract
import com.example.qrcone.data.QrCodeData
import com.example.qrcone.data.cloud.QrCodeCloudToDataMapper
import java.util.*

data class QrCodeCache(
    private val title: String,
    private val base64: Base64
) {

}