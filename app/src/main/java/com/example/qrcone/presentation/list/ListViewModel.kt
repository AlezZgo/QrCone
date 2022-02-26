package com.example.qrcone.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.qrcone.domain.QrCodeInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val qrCodeInteractor: QrCodeInteractor
) : ViewModel() {

    val qrCodes = qrCodeInteractor.fetchQrCodes()

}