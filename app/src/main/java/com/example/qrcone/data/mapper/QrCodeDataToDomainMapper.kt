package com.example.qrcone.data.mapper

import com.example.qrcone.core.Abstract
import com.example.qrcone.data.QrCodeData
import com.example.qrcone.data.cache.QrCodeCache
import com.example.qrcone.domain.QrCodeDomain
import java.lang.Exception

interface QrCodeDataToDomainMapper : Abstract.Mapper {

    fun map(
        title: String,
        mediaBase64: String,
        content: String,
    ): QrCodeDomain

    fun map(
        e: Exception
    ): QrCodeDomain

}
