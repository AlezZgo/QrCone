package com.example.starwarscharacters.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.qrcone.presentation.QrCodeUi
import com.example.starwarscharacters.domain.entities.CharacterInfo

class QrCodeDiffCallback : DiffUtil.ItemCallback<QrCodeUi>() {

    override fun areItemsTheSame(oldItem: QrCodeUi, newItem: QrCodeUi): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: QrCodeUi, newItem: QrCodeUi): Boolean {
        return oldItem == newItem
    }
}