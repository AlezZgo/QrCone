package com.example.qrcone.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.qrcone.core.Abstract
import com.example.qrcone.data.QrCodeData
import com.example.qrcone.data.mapper.QrCodeCacheToDataMapper

@Entity(tableName = "qrCodes")
data class QrCodeCache(
    @PrimaryKey
    val title: String,
    var mediaBase64: String,
    val content: String,
) : Abstract.Object<QrCodeData, QrCodeCacheToDataMapper> {
    override fun map(mapper: QrCodeCacheToDataMapper) = mapper.map(title, mediaBase64, content)
}


