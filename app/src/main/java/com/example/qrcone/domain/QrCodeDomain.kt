package com.example.qrcone.domain

import com.example.qrcone.core.Abstract
import com.example.qrcone.data.QrCodeData
import com.example.qrcone.data.mapper.QrCodeDataToDomainMapper
import com.example.qrcone.presentation.QrCodeUi
import java.lang.Exception

sealed class QrCodeDomain : Abstract.Object<QrCodeUi, QrCodeDomainToUiMapper> {

    class Success(
        private val title: String,
        private val mediaBase64: String,
        private val content: String,
    ): QrCodeDomain() {
        override fun map(mapper: QrCodeDomainToUiMapper): QrCodeUi {
            TODO("Not yet implemented")
        }


    }

    class Failure(e: Exception) : QrCodeDomain() {
        override fun map(mapper: QrCodeDomainToUiMapper): QrCodeUi {
            TODO("Not yet implemented")
        }


    }


}