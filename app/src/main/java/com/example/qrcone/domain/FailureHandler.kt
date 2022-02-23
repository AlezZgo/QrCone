package com.example.qrcone.domain

import com.example.qrcone.presentation.Failure

interface FailureHandler {
    fun handle(e: Exception): Failure
}
