package com.example.qrcone

import android.util.Log
import com.example.qrcone.core.QrConeApp
import org.junit.Assert
import org.junit.Test
import java.util.*

class QrConeApiTest {

    @Test
    suspend fun apiResponse() {
        val application = QrConeApp()
        val api = application.getApi()

        val str = "test image"
        val encodedImage = Base64.getEncoder().encodeToString(str.toByteArray())

        try {
            val response = api.generateQrCode(0,false,"Hello world!",encodedImage)
            Assert.assertEquals(response, String)
        }catch (e: Exception){
            Log.i("test", "something going wrong while generating")
        }


    }

}