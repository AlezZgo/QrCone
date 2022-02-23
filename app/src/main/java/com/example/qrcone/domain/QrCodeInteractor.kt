package com.example.qrcone.domain

import androidx.lifecycle.LiveData
import com.example.qrcone.data.QrCodeRepository
import com.example.qrcone.presentation.QrCodeUi

interface QrCodeInteractor {
    suspend fun generateQrCode(qrCodeRequest: QrCodeRequest) : QrCodeUi

    fun qrCodes(): LiveData<List<QrCodeUi>>

    class Base(private val repository: QrCodeRepository) : QrCodeInteractor{

        override suspend fun generateQrCode(qrCodeRequest: QrCodeRequest): QrCodeUi {
            return repository.generateQrCode(qrCodeRequest)
        }

        override fun qrCodes(): LiveData<List<QrCodeUi>> {
            TODO("Not yet implemented")
        }

    }
}