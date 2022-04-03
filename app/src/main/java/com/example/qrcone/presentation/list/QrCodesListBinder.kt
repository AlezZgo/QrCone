package com.example.qrcone.presentation.list

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.qrcone.core.Binder
import com.example.qrcone.domain.QrCodeDomain
import javax.inject.Inject

interface QrCodesListBinder : Binder<List<QrCodeDomain>> {

    class Base @Inject constructor() : QrCodesListBinder{
        private lateinit var liveData : LiveData<List<QrCodeDomain>>

        override fun observe(owner: LifecycleOwner, observer: Observer<List<QrCodeDomain>>) =
            liveData.observe(owner, observer)

        override fun bind(data:LiveData<List<QrCodeDomain>>){
            liveData = data
        }
    }
}