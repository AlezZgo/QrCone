package com.example.qrcone.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.qrcone.data.cache.CacheDataSource
import com.example.qrcone.data.cache.QrCodeCache
import com.example.qrcone.data.cloud.CloudDataSource
import com.example.qrcone.domain.QrCodeDomain
import com.example.qrcone.domain.QrCodeRequest
import javax.inject.Inject

interface QrCodeRepository {

    fun fetchQrCodes(): LiveData<List<QrCodeDomain>>

    suspend fun generateQrCode(qrCodeRequest: QrCodeRequest): QrCodeDomain

    suspend fun deleteQrCode(qrCodeDomain: QrCodeDomain)

    class Base @Inject constructor(
        private val qrCodeCacheDataSource: CacheDataSource,
        private val qrCodeCloudDataSource: CloudDataSource,
        private val qrCodeCacheDomainMapper: QrCodeCacheDomainMapper,
        private val application: Application,
    ) : QrCodeRepository {

        override fun fetchQrCodes(): LiveData<List<QrCodeDomain>> {

            return Transformations.map(qrCodeCacheDataSource.fetchQrCodes()) { list ->
                list.map {
                    qrCodeCacheDomainMapper.mapCacheToDomain(it)
                }
            }
        }

        override suspend fun generateQrCode(qrCodeRequest: QrCodeRequest): QrCodeDomain {

            val masterKeyAlias: String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

            val encryptedSharedPrefs = EncryptedSharedPreferences.create(
                "secret_shared_prefs",
                masterKeyAlias,
                application,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )

            val imageB64 = qrCodeCloudDataSource.createQrCode(qrCodeRequest,
                encryptedSharedPrefs.getString("user_id", "-100") ?: "-100")
            val qrCodeCache = QrCodeCache(qrCodeRequest.title, imageB64, qrCodeRequest.content)
            qrCodeCacheDataSource.insertQrCode(qrCodeCache)
            return qrCodeCacheDomainMapper.mapCacheToDomain(qrCodeCache)
        }

        override suspend fun deleteQrCode(qrCodeDomain: QrCodeDomain) {
            qrCodeCacheDataSource.deleteQrCode(qrCodeCacheDomainMapper.mapDomainToCache(qrCodeDomain))
        }
    }


}