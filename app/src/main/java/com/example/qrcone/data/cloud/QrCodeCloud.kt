package com.example.qrcone.data.cloud

import com.example.qrcone.core.Abstract
import com.example.qrcone.data.QrCodeData
import com.google.gson.annotations.SerializedName
import java.util.*

data class QrCodeCloud(
    @SerializedName("type")
    private val type: Int,
    @SerializedName("colored")
    private val colored: Boolean,
    @SerializedName("media")
    private val media: Base64
) : Abstract.Object<QrCodeData,QrCodeCloudToDataMapper>{


}
