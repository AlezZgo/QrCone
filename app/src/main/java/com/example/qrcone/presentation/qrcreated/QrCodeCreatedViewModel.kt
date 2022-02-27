package com.example.qrcone.presentation.qrcreated

import androidx.lifecycle.ViewModel
import com.example.qrcone.domain.QrCodeDomain
import com.example.qrcone.domain.QrCodeInteractor
import com.example.qrcone.domain.QrCodeRequest
import javax.inject.Inject

class QrCodeCreatedViewModel @Inject constructor(
    private val interactor: QrCodeInteractor
) : ViewModel() {

    suspend fun generateQrCode(qrCodeRequest: QrCodeRequest): QrCodeDomain{
        return interactor.generateQrCode(qrCodeRequest)
    }
}