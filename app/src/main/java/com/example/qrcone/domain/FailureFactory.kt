package com.example.qrcone.domain

import com.example.qrcone.core.Failure
import com.example.qrcone.presentation.ResourceManager

class FailureFactory(private val resourceManager: ResourceManager) : FailureHandler {
    override fun handle(e: Exception) = when (e) {
        is NoConnectionException -> Failure.NoConnection(resourceManager)
        is NoCachedDataException -> Failure.NoCachedData(resourceManager)
        is ServiceUnavailableException -> Failure.ServiceUnavailable(resourceManager)
        else -> Failure.GenericError(resourceManager)
    }
}