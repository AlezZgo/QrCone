package com.example.qrcone.data.mapper

import com.example.qrcone.core.Abstract
import com.example.qrcone.data.cache.QrCodeCache
import com.example.qrcone.domain.QrCodeRequest

interface QrCodeRequestToCacheMapper : Abstract.Mapper  {

    fun map(qrCodeRequest: QrCodeRequest) : QrCodeCache

}
