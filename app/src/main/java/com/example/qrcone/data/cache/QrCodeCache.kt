package com.example.qrcone.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.qrcone.core.Abstract
import com.example.qrcone.data.QrCodeData
import com.example.qrcone.data.cloud.QrCodeCloudToDataMapper
import java.util.*

@Entity(tableName = "qrCodes")
data class QrCodeCache(
    @PrimaryKey
    val title: String,
    val media: String
) {

}