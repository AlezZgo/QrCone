package com.example.qrcone.data.mapper

import com.example.qrcone.core.Abstract
import com.example.qrcone.data.QrCodeData
import java.lang.Exception

interface QrCodeCacheToDataMapper : Abstract.Mapper {

    fun map(
        title: String,
        mediaBase64: String,
        content: String,
    ): QrCodeData

    fun map(
        e: Exception
    ): QrCodeData

    class Base : QrCodeCacheToDataMapper {

        override fun map(title: String, mediaBase64: String, content: String): QrCodeData {
            return QrCodeData.Success(
                title,
                mediaBase64,
                content
            )
        }

        override fun map(e: Exception): QrCodeData {
            return QrCodeData.Failure(e)
        }
    }
}
