package com.example.starwarscharacters.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.qrcone.databinding.ItemQrcodeBinding
import com.example.qrcone.domain.QrCodeDomain
import com.example.qrcone.presentation.QrCodeUi

class QrCodeAdapter(
    private val onQrCodeClickListener: OnQrCodeClickListener,
) : ListAdapter<QrCodeDomain, QrCodeViewHolder>(QrCodeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QrCodeViewHolder {
        val binding = ItemQrcodeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return QrCodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QrCodeViewHolder, position: Int) {
        val qrCode = getItem(position)
        holder.bind(qrCode, onQrCodeClickListener)
    }

    interface OnQrCodeClickListener {
        fun onQrCodeClick(qrCode: QrCodeDomain)
    }

}