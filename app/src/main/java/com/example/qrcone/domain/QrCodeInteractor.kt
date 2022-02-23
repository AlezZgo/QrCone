package com.example.qrcone.domain

import androidx.lifecycle.LiveData
import com.example.qrcone.data.QrCodeRepository
import com.example.qrcone.presentation.QrCodeUi
import java.lang.Exception

interface QrCodeInteractor {
    suspend fun generateQrCode(qrCodeRequest: QrCodeRequest) : QrCodeUi

    fun qrCodes(): LiveData<List<QrCodeUi>>

    class Base(private val repository: QrCodeRepository,
               private val failureHandler: FailureHandler,
               private val mapper: QrCodeDataToUiMapper
    ) : QrCodeInteractor{

        override suspend fun generateQrCode(qrCodeRequest: QrCodeRequest): QrCodeUi {
            return try {
                repository.generateQrCode(qrCodeRequest).map(mapper)
            }catch (e: Exception){

            }

        }

        override fun qrCodes(): LiveData<List<QrCodeUi>> {
            TODO("Not yet implemented")
        }

    }
}