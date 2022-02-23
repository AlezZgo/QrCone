package com.example.qrcone.data.mapper

import com.example.qrcone.core.Abstract
import com.example.qrcone.data.QrCodeData

interface QrCodeCacheToDataMapper : Abstract.Mapper {

    fun map(
        title: String,
        mediaBase64: String,
        content: String,
    ): QrCodeData

    class Base : QrCodeCacheToDataMapper {

        override fun map(title: String, mediaBase64: String, content: String): QrCodeData {
            return QrCodeData.Success(
                title,
                mediaBase64,
                content
            )
        }
    }
}
