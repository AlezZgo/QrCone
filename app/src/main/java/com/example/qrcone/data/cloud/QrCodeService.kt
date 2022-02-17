package com.example.qrcone.data.cloud

import com.example.qrcone.data.QrCodeData

interface QrCodeDataFetcher {

    suspend fun fetch() : QrCodeData
}