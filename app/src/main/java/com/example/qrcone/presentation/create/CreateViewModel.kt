package com.example.qrcone.presentation.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.qrcone.data.cache.QrCodeCache
import com.example.qrcone.domain.QrCodeDomain
import com.example.qrcone.domain.QrCodeInteractor
import com.example.qrcone.domain.QrCodeRequest
import javax.inject.Inject

class CreateViewModel @Inject constructor(
) : ViewModel() {
    var currentColor : String = "000000"
    var imagePath : String? = null
}