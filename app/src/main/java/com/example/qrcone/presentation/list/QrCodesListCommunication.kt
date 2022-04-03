package com.example.qrcone.presentation.list

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.qrcone.domain.QrCodeDomain
import javax.inject.Inject

interface QrCodesListCommunication {

    fun observe(owner: LifecycleOwner, observer: Observer<List<QrCodeDomain>>)

    fun follow(data: LiveData<List<QrCodeDomain>>)

    class Base @Inject constructor() : QrCodesListCommunication{
        private lateinit var liveData : LiveData<List<QrCodeDomain>>

        override fun observe(owner: LifecycleOwner, observer: Observer<List<QrCodeDomain>>) =
            liveData.observe(owner, observer)

        override fun follow(data:LiveData<List<QrCodeDomain>>){
            liveData = data
        }

    }

}