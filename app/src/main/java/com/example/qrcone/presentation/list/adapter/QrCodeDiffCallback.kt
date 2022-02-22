package com.example.starwarscharacters.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.qrcone.presentation.QrCodeUi

class QrCodeDiffCallback : DiffUtil.ItemCallback<QrCodeUi>() {

    override fun areItemsTheSame(oldItem: QrCodeUi, newItem: QrCodeUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: QrCodeUi, newItem: QrCodeUi): Boolean {
        return oldItem == newItem
    }
}