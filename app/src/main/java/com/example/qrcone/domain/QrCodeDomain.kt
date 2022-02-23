package com.example.qrcone.domain

import com.example.qrcone.core.Mapper
import com.example.qrcone.presentation.QrCodeUi

sealed class QrCodeDomain : Mapper<QrCodeUi> {

    class Success(
        private val title: String,
        private val mediaBase64: String,
        private val content: String,
    ) : QrCodeDomain() {
        override fun to(): QrCodeUi {
            TODO("Not yet implemented")
        }

    }

    class Failed(e: Exception) : QrCodeDomain() {
        override fun to(): QrCodeUi {
            TODO("Not yet implemented")
        }


    }

}