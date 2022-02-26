package com.example.qrcone.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.qrcone.data.cache.CacheDataSource
import com.example.qrcone.data.cloud.CloudDataSource
import com.example.qrcone.data.mapper.QrCodeCacheToDomainMapper
import com.example.qrcone.domain.QrCodeDomain
import com.example.qrcone.domain.QrCodeRequest
import javax.inject.Inject

interface QrCodeRepository {

    fun fetchQrCodes() : LiveData<List<QrCodeDomain>>

    suspend fun generateQrCode(qrCodeRequest: QrCodeRequest)

    class Base @Inject constructor(private val qrCodeCacheDataSource: CacheDataSource,
                                  private val qrCodeCacheToDomainMapper: QrCodeCacheToDomainMapper
    ) : QrCodeRepository {

        override fun fetchQrCodes(): LiveData<List<QrCodeDomain>> {
            return Transformations.map(qrCodeCacheDataSource.fetchQrCodes()){list->
                list.map {
                    qrCodeCacheToDomainMapper.map(it)
                }
            }
        }

        override suspend fun generateQrCode(qrCodeRequest: QrCodeRequest)  {
            //TODO() not implemented
        }
    }


}