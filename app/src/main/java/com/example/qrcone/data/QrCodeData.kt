package com.example.qrcone.data

import com.example.qrcone.core.Abstract
import com.example.qrcone.data.mapper.QrCodeDataToDomainMapper
import com.example.qrcone.domain.QrCodeDomain
import com.example.qrcone.domain.QrCodeDomainToUiMapper
import com.example.qrcone.presentation.QrCodeUi
import java.util.*

sealed class QrCodeData : Abstract.Object<QrCodeDomain, QrCodeDataToDomainMapper>{

    class Success(
        private val title: String,
        private val mediaBase64: String,
        private val content: String,
    ): QrCodeData() {
        override fun map(mapper: QrCodeDataToDomainMapper): QrCodeDomain {
            mapper.map(title,mediaBase64,content)
        }


    }


}