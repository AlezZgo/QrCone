package com.example.qrcone.presentation.main

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.qrcone.R


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}


//    companion object {
//        private const val baseUrl = "https://swapi.dev/"
//    }


//    private fun request() {
//
//        val interceptor = HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//
//        val client = OkHttpClient.Builder()
//            .addInterceptor(interceptor)
//            .build()
//
//        val retrofit = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(baseUrl)
//            .client(client)
//            .build()
//
//        val api = retrofit.create(QrConeApiService::class.java)
//
//        val file = File("/storage/emulated/0/Download/image.jpg")
//
//        val br = 0
//
//        val description = QrCodeCloudRequest(0,false,"Hello world")
//
//        CoroutineScope(Dispatchers.IO + Job()).launch {
//
//
//            api.generateQrCode(
//                MultipartBody.Part.createFormData("text/plain",description.toString()),
//                MultipartBody.Part.createFormData(
//                    "file",
//                    file.path,
//                    file.asRequestBody("multipart/form-data".toMediaTypeOrNull()))
//            ).enqueue(object : Callback<ResponseBody> {
//                override fun onResponse(
//                    call: Call<ResponseBody>,
//                    response: Response<ResponseBody>
//                ) {
//                    if (response.isSuccessful)
//                        Log.d("logir", "${response.body()}")
//                }
//
//                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                    Log.e("logir", t.message.toString())
//                }
//
//            })
//        }
//    }
