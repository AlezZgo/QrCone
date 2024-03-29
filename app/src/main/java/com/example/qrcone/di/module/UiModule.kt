package com.example.qrcone.di.module

import com.example.qrcone.presentation.list.QrCodesListCommunication
import dagger.Binds
import dagger.Module

@Module
interface UiModule {

    @Binds
    fun bindBinder(communication: QrCodesListCommunication.Base): QrCodesListCommunication


}