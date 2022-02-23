package com.example.qrcone.domain

import com.example.qrcone.core.Abstract
import com.example.qrcone.data.mapper.QrCodeRequestToCacheMapper
import com.example.qrcone.data.cache.QrCodeCache

data class QrCodeRequest(
    private val title: String,
    private val colored: Boolean,
    private val mediaUri: String,
    private val content: String
) : Abstract.Object<QrCodeCache, QrCodeRequestToCacheMapper> {

    override fun map(mapper: QrCodeRequestToCacheMapper): QrCodeCache {
        TODO("Not yet implemented")
    }
}
