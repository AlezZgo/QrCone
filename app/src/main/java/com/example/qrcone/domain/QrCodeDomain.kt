package com.example.qrcone.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QrCodeDomain(
    val title: String,
    val mediaBase64: String,
    val content: String,
) : Parcelable