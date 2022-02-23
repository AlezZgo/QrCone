package com.example.qrcone.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.qrcone.data.cache.CacheDataSource
import com.example.qrcone.data.cache.QrCodeCache
import com.example.qrcone.data.mapper.QrCodeCacheToDataMapper

interface QrCodeRepository {

    fun fetchQrCodes() : LiveData<List<QrCodeData>>

    suspend fun generateQrCode(qrCodeCache: QrCodeCache)

    class Base(private val qrCodeCacheDataSource: CacheDataSource,
               private val cacheToDataMapper: QrCodeCacheToDataMapper) : QrCodeRepository {
        override fun fetchQrCodes(): LiveData<List<QrCodeData>> {
            return Transformations.map(qrCodeCacheDataSource.fetchQrCodes()){list->
                list.map {
                    cacheToDataMapper.map(it.title,it.mediaBase64,it.content)
                }
            }
        }

        override suspend fun generateQrCode(qrCodeCache: QrCodeCache) {
            TODO("Not yet implemented")
        }
    }


}