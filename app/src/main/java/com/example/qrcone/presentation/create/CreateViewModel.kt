package com.example.qrcone.presentation.create

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CreateViewModel @Inject constructor(
) : ViewModel() {
    var currentColor: String = "000000"
    var imagePath: String? = null
}