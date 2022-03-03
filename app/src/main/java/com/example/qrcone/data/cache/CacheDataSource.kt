package com.example.qrcone.data.cache

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import com.example.qrcone.domain.QrCodeDomain
import javax.inject.Inject

interface CacheDataSource {
    fun fetchQrCodes() : LiveData<List<QrCodeCache>>

    fun getCurrentUserId() : String

    suspend fun insertQrCode(qrCodeCache: QrCodeCache)

    suspend fun deleteQrCode(qrCodeDomain: QrCodeCache)

    class Base @Inject constructor(private val qrCodeDao: QrCodeDao,
                                   private val sharedPreferences: SharedPreferences) : CacheDataSource{
        override fun fetchQrCodes(): LiveData<List<QrCodeCache>> {
            return qrCodeDao.qrCodeList()
        }

        override fun getCurrentUserId(): String {
            return sharedPreferences.getString("user_id","-1")?:"-1"
        }

        override suspend fun insertQrCode(qrCodeCache: QrCodeCache) {
            qrCodeDao.insert(qrCodeCache)
        }

        override suspend fun deleteQrCode(qrCodeCache: QrCodeCache) {
            qrCodeDao.delete(qrCodeCache.title)
        }

    }
}