package com.example.starwarscharacters.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.qrcone.domain.QrCodeDomain

class QrCodeDiffCallback : DiffUtil.ItemCallback<QrCodeDomain>() {

    override fun areItemsTheSame(oldItem: QrCodeDomain, newItem: QrCodeDomain): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: QrCodeDomain, newItem: QrCodeDomain): Boolean {
        return oldItem == newItem
    }
}