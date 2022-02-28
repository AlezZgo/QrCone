package com.example.qrcone.data.cloud

import android.util.Log
import com.example.qrcone.domain.QrCodeRequest
import kotlinx.coroutines.delay
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.internal.toHexString
import java.io.File
import javax.inject.Inject

interface CloudDataSource {

    suspend fun createQrCode(
        qrCodeRequest: QrCodeRequest,
    ): String

    class Test @Inject constructor(private val service: QrConeApiService) : CloudDataSource {
        override suspend fun createQrCode(
            qrCodeRequest: QrCodeRequest,
        ): String {
            delay(2000)
            return TEST_BASE64_QR_CODE
        }



        companion object {
            private const val TEST_BASE64_QR_CODE =
                "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"
        }
    }

    class Base @Inject constructor(private val service: QrConeApiService) : CloudDataSource{
        override suspend fun createQrCode(qrCodeRequest: QrCodeRequest): String {

            val file = File(qrCodeRequest.mediaPath)

            val formData = MultipartBody.Part.createFormData(
                "file",
                file.path,
                file.asRequestBody("multipart/form-data".toMediaType())
            )

            return service.generate(formData,"Black",qrCodeRequest.content)
        }

    }

}