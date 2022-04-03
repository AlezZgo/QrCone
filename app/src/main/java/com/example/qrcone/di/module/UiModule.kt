package com.example.qrcone.di.module

import com.example.qrcone.presentation.list.QrCodesListBinder
import dagger.Binds
import dagger.Module

@Module
interface UiModule {

    @Binds
    fun bindOnCommunication(binder: QrCodesListBinder.Base): QrCodesListBinder


}