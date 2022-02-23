package com.example.qrcone.core

import androidx.annotation.StringRes
import com.example.qrcone.R
import com.example.qrcone.presentation.ResourceManager

interface Failure {
    fun getMessage(): String

    abstract class Base(private val resourceManager: ResourceManager) : Failure {

        @StringRes
        protected abstract fun getMessageResId(): Int

        override fun getMessage(): String = resourceManager.getString(getMessageResId())
    }

    class NoConnection(resourceManager: ResourceManager) : Base(resourceManager) {
        override fun getMessageResId() = R.string.no_connection
    }

    class ServiceUnavailable(resourceManager: ResourceManager) : Base(resourceManager) {
        override fun getMessageResId() = R.string.service_unavailable
    }

    class NoCachedData(resourceManager: ResourceManager) : Base(resourceManager) {
        override fun getMessageResId() = R.string.no_cached_data
    }

    class GenericError(resourceManager: ResourceManager) : Base(resourceManager) {
        override fun getMessageResId() = R.string.generic_fail_message
    }
}