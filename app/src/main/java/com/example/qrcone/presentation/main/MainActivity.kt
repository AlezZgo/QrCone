package com.example.qrcone.presentation.main

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.qrcone.R
import com.example.qrcone.data.cloud.QrCodeCloudRequest
import com.example.qrcone.data.cloud.QrConeApiService
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        request()

    }

    private fun request() {

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

        val description = Gson().toJson(QrCodeCloudRequest(false,  "Hello world"))

        CoroutineScope(Dispatchers.IO + Job()).launch {

            api.generateQrCode(
                MultipartBody.Part.createFormData("text/plain", description),
                MultipartBody.Part.createFormData(
                    "file",
                    file.path,
                    file.asRequestBody("multipart/form-data".toMediaTypeOrNull()))
            ).enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>,
                ) {
                    if (response.isSuccessful)
                        Log.d("logir", "${response.body()}")
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.e("logir", t.message.toString())
                }
            })
        }
    }

    companion object {
        private const val baseUrl = "https://qrcone.herokuapp.com/"
    }

}









