package com.example.qrcone.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.qrcone.data.cache.CacheDataSource
import com.example.qrcone.data.cloud.CloudDataSource
import com.example.qrcone.data.mapper.QrCodeCacheToDataMapper
import com.example.qrcone.data.mapper.QrCodeRequestToCacheMapper
import com.example.qrcone.domain.QrCodeRequest

interface QrCodeRepository {

    fun fetchQrCodes() : LiveData<List<QrCodeData>>

    suspend fun generateQrCode(qrCodeRequest: QrCodeRequest) : QrCodeData

    class Base(private val qrCodeCacheDataSource: CacheDataSource,
               private val qrCodeCloudDataSource: CloudDataSource,
               private val cacheToDataMapper: QrCodeCacheToDataMapper,
               private val requestToCacheMapper: QrCodeRequestToCacheMapper
    ) : QrCodeRepository {

        override fun fetchQrCodes(): LiveData<List<QrCodeData>> {
            return Transformations.map(qrCodeCacheDataSource.fetchQrCodes()){list->
                list.map {
                    cacheToDataMapper.map(it.title,it.mediaBase64,it.content)
                }
            }
        }

        override suspend fun generateQrCode(qrCodeRequest: QrCodeRequest): QrCodeData {
            val qrCodeGenerated = qrCodeCloudDataSource.createQrCode(qrCodeRequest)
            val qrCodeCache = qrCodeRequest.map(requestToCacheMapper).copy(mediaBase64 = qrCodeGenerated)
            qrCodeCacheDataSource.insertQrCode(qrCodeCache)
            return qrCodeCache.map(cacheToDataMapper)
        }
    }


}