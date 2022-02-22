package com.example.qrcone.presentation.main

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.qrcone.R
import com.example.qrcone.data.cloud.QrCodeCloudRequest
import com.example.qrcone.data.cloud.QrConeApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO + Job()).launch {
            request()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun request() {

        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()

        val api = retrofit.create(QrConeApiService::class.java)

        val file = File("/storage/emulated/0/Download/image.jpg")

        val body = QrCodeCloudRequest(
            0,
            false,
            "https://helloworld!"
        )

        val response = api.generateQrCode(body,
            MultipartBody.Part.createFormData(
                "file",
                file.path,
                file.asRequestBody("multipart/form-data".toMediaTypeOrNull())
            ))

    }

    companion object {
        private const val baseUrl = "https://swapi.dev/"
    }


}