package com.example.qrcone.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QrCodeRequest(
    val title: String,
    val color: String,
    val content: String,
    val mediaPath: String,
) : Parcelable
