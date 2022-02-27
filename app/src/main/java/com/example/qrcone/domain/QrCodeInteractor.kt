package com.example.qrcone.domain

import androidx.lifecycle.LiveData
import com.example.qrcone.data.QrCodeRepository
import javax.inject.Inject

interface QrCodeInteractor {
    
    fun fetchQrCodes(): LiveData<List<QrCodeDomain>>

    suspend fun generateQrCode(qrCodeRequest: QrCodeRequest) : QrCodeDomain

    fun removeQrCode(qrCodeDomain : QrCodeDomain)

    class Base @Inject constructor(private val repository: QrCodeRepository): QrCodeInteractor{
        override fun fetchQrCodes(): LiveData<List<QrCodeDomain>> {
            return repository.fetchQrCodes()
        }

        override suspend fun generateQrCode(qrCodeRequest: QrCodeRequest): QrCodeDomain {
            return repository.generateQrCode(qrCodeRequest)
        }

        override fun removeQrCode(qrCodeDomain: QrCodeDomain) {
            TODO("Not yet implemented")
        }

    }
}