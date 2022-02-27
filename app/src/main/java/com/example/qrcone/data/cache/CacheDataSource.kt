package com.example.qrcone.data.cache

import androidx.lifecycle.LiveData
import com.example.qrcone.domain.QrCodeDomain

interface CacheDataSource {
    fun fetchQrCodes() : LiveData<List<QrCodeCache>>

    suspend fun insertQrCode(qrCodeCache: QrCodeCache)

    suspend fun deleteQrCode(qrCodeDomain: QrCodeCache)

    class Base(private val qrCodeDao: QrCodeDao) : CacheDataSource{
        override fun fetchQrCodes(): LiveData<List<QrCodeCache>> {
            return qrCodeDao.qrCodeList()
        }

        override suspend fun insertQrCode(qrCodeCache: QrCodeCache) {
            qrCodeDao.insert(qrCodeCache)
        }

        override suspend fun deleteQrCode(qrCodeCache: QrCodeCache) {
            qrCodeDao.delete(qrCodeCache.title)
        }

    }
}