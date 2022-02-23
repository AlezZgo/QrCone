package com.example.qrcone.data

import com.example.qrcone.core.Abstract
import com.example.qrcone.data.mapper.QrCodeDataToDomainMapper
import com.example.qrcone.domain.QrCodeDomain

sealed class QrCodeData : Abstract.Object<QrCodeDomain, QrCodeDataToDomainMapper> {

    class Success(
        private val title: String,
        private val mediaBase64: String,
        private val content: String,
    ) : QrCodeData() {
        override fun map(mapper: QrCodeDataToDomainMapper) = mapper.map(title, mediaBase64, content)
    }

    class Failure(private val e: Exception) : QrCodeData() {
        override fun map(mapper: QrCodeDataToDomainMapper) = mapper.map(e)
    }
}