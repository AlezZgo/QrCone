package com.example.qrcone.presentation.main

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.qrcone.R
import com.example.qrcone.data.cloud.QrCodeCloudRequest
import com.example.qrcone.data.cloud.QrConeApiService
import kotlinx.coroutines.*
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.MultipartBody.Part.Companion.createFormData
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.*


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO + Job()).launch{
            request()
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun request(){

        val str = "test image"
        val encodedImage = Base64.getEncoder().encodeToString(str.toByteArray())

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

        try {
            val response = api.generateQrCode(body,
                MultipartBody.Part.createFormData(
                    "file",
                    file.path,
                    file.asRequestBody("multipart/form-data".toMediaTypeOrNull())
                ))
        }catch (e: Exception){
            Log.i("test", "something going wrong while generating")
        }
    }

    companion object {
        private const val baseUrl = "https://swapi.dev/"
    }




}