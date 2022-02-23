package com.example.qrcone.data.cache

import androidx.lifecycle.LiveData

interface CacheDataSource {
    fun fetchQrCodes() : LiveData<List<QrCodeCache>>

    suspend fun insertQrCode(qrCodeCache: QrCodeCache,generatedQrCodeBase64: String)

    class Base(private val qrCodeDao: QrCodeDao) : CacheDataSource{
        override fun fetchQrCodes(): LiveData<List<QrCodeCache>> {
            return qrCodeDao.qrCodeList()
        }

        override suspend fun insertQrCode(qrCodeCache: QrCodeCache,generatedQrCodeBase64: String) {
            qrCodeDao.insert(qrCodeCache.apply {
                mediaBase64 = generatedQrCodeBase64
            })
        }

    }
}