package com.example.qrcone.domain

data class QrCodeRequest(
    val title: String,
    val colored: Boolean,
    val mediaUri: String,
    val content: String,
)
