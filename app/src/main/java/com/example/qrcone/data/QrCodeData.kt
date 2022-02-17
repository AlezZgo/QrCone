package com.example.qrcone.data

import com.example.qrcone.core.Abstract
import com.example.qrcone.domain.QrCodeDomain

sealed class QrCodeData : Abstract.Object<QrCodeDomain,QrCodeDataToDomainMapper>{
}