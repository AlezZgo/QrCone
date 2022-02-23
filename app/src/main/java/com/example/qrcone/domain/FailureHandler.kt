package com.example.qrcone.domain

import com.example.qrcone.core.Failure

interface FailureHandler {
    fun handle(e: Exception): Failure
}
