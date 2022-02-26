package com.example.qrcone.data.mapper

import com.example.qrcone.data.cache.QrCodeCache
import com.example.qrcone.domain.QrCodeDomain

interface QrCodeCacheToDomainMapper {

    fun map(qrCodeCache: QrCodeCache): QrCodeDomain

    class Base : QrCodeCacheToDomainMapper{
        override fun map(qrCodeCache: QrCodeCache): QrCodeDomain {
            return QrCodeDomain(qrCodeCache.title,qrCodeCache.mediaBase64,qrCodeCache.content)
        }
    }
}
