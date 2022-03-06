package com.example.qrcone.data

import com.example.qrcone.data.cache.QrCodeCache
import com.example.qrcone.domain.QrCodeDomain

interface QrCodeCacheDomainMapper {

    fun mapCacheToDomain(qrCodeCache: QrCodeCache): QrCodeDomain

    fun mapDomainToCache(qrCodeDomain: QrCodeDomain): QrCodeCache

    class Base : QrCodeCacheDomainMapper {
        override fun mapCacheToDomain(qrCodeCache: QrCodeCache): QrCodeDomain {
            return QrCodeDomain(qrCodeCache.title, qrCodeCache.mediaBase64, qrCodeCache.content)
        }

        override fun mapDomainToCache(qrCodeDomain: QrCodeDomain): QrCodeCache {
            return QrCodeCache(qrCodeDomain.title, qrCodeDomain.mediaBase64, qrCodeDomain.content)
        }
    }
}
