package com.example.qrcone.domain

data class QrCodeRequest(
    private val title: String,
    private val colored: Boolean,
    private val mediaPath: String,
    private val content: String
)
