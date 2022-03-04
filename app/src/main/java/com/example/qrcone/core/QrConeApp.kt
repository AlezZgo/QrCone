package com.example.qrcone.core

import DaggerApplicationComponent
import android.app.Application

class QrConeApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}