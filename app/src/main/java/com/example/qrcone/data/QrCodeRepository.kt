package com.example.qrcone.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.qrcone.data.cache.CacheDataSource
import com.example.qrcone.data.cache.QrCodeCache
import com.example.qrcone.data.cloud.CloudDataSource
import com.example.qrcone.domain.QrCodeDomain
import com.example.qrcone.domain.QrCodeRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

interface QrCodeRepository {

    fun fetchQrCodes(): LiveData<List<QrCodeDomain>>

    suspend fun generateQrCode(qrCodeRequest: QrCodeRequest) : QrCodeDomain

    class Base @Inject constructor(
        private val qrCodeCacheDataSource: CacheDataSource,
        private val qrCodeCloudDataSource: CloudDataSource,
        private val qrCodeCacheToDomainMapper: QrCodeCacheToDomainMapper,

        ) : QrCodeRepository {

        override fun fetchQrCodes(): LiveData<List<QrCodeDomain>> {

            return Transformations.map(qrCodeCacheDataSource.fetchQrCodes()) { list ->
                list.map {
                    qrCodeCacheToDomainMapper.map(it)
                }
            }
        }

        override suspend fun generateQrCode(qrCodeRequest: QrCodeRequest) : QrCodeDomain {
            val imageB64 = qrCodeCloudDataSource.createQrCode(qrCodeRequest)
            val qrCodeCache = QrCodeCache(qrCodeRequest.title,imageB64,qrCodeRequest.content)
            qrCodeCacheDataSource.insertQrCode(qrCodeCache)
            return qrCodeCacheToDomainMapper.map(qrCodeCache)
        }
    }


}