package com.example.qrcone.di.module

import ApplicationScope
import android.app.Application
import com.example.qrcone.data.QrCodeRepository
import com.example.qrcone.data.cache.AppDatabase
import com.example.qrcone.data.cache.QrCodeDao
import com.example.qrcone.domain.QrCodeInteractor
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DomainModule {

    @ApplicationScope
    @Binds
    fun bindQrCodeInteractor(impl: QrCodeInteractor.Base): QrCodeInteractor

    @ApplicationScope
    @Provides
    fun provideQrCodeInteractor(qrCodeRepository: QrCodeRepository): QrCodeInteractor.Base {
        return QrCodeInteractor.Base(qrCodeRepository)
    }


}