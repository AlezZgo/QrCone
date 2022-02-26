package com.example.qrcone.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.qrcone.core.Abstract
import com.example.qrcone.data.QrCodeData

@Entity(tableName = "qrCodes")
data class QrCodeCache(
    @PrimaryKey
    val title: String,
    var mediaBase64: String,
    val content: String,
)

