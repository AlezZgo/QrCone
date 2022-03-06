package com.example.qrcone.presentation.list

import androidx.lifecycle.ViewModel
import com.example.qrcone.domain.QrCodeDomain
import com.example.qrcone.domain.QrCodeInteractor
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val qrCodeInteractor: QrCodeInteractor,
) : ViewModel() {

    suspend fun delete(qrCodeDomain: QrCodeDomain) {
        qrCodeInteractor.removeQrCode(qrCodeDomain)
    }

    val qrCodes = qrCodeInteractor.fetchQrCodes()

}