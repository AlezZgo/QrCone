package com.example.qrcone.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

interface Binder<T>{

    fun observe(owner: LifecycleOwner, observer: Observer<T>)

    fun bind(data: LiveData<T>)

}