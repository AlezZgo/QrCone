package com.example.qrcone.domain

import androidx.lifecycle.LiveData
import com.example.qrcone.data.QrCodeRepository

interface QrCodeInteractor {
    
    fun fetchQrCodes(): LiveData<List<QrCodeDomain>>

    suspend fun generateQrCode(qrCodeRequest: QrCodeRequest) : QrCodeDomain

    fun removeQrCode(qrCodeDomain : QrCodeDomain)

    class Base(private val repository: QrCodeRepository): QrCodeInteractor{
        override fun fetchQrCodes(): LiveData<List<QrCodeDomain>> {
            return repository.fetchQrCodes()
        }

        override suspend fun generateQrCode(qrCodeRequest: QrCodeRequest): QrCodeDomain {
            TODO("Not yet implemented")
        }

        override fun removeQrCode(qrCodeDomain: QrCodeDomain) {
            TODO("Not yet implemented")
        }

    }
}