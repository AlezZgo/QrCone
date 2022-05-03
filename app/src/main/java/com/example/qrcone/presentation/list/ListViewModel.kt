package com.example.qrcone.presentation.list

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.qrcone.domain.QrCodeDomain
import com.example.qrcone.domain.QrCodeInteractor
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val qrCodeInteractor: QrCodeInteractor,
    private val qrCodesListCommunication: QrCodesListCommunication
) : ViewModel() {

    suspend fun delete(qrCodeDomain: QrCodeDomain) {
        qrCodeInteractor.removeQrCode(qrCodeDomain)
    }

    fun observeList(owner: LifecycleOwner, observer: Observer<List<QrCodeDomain>>){
        qrCodesListCommunication.observe(owner, observer)
    }

    fun fetchQrCodes(){
        qrCodesListCommunication.bind(qrCodeInteractor.fetchQrCodes())
    }


}