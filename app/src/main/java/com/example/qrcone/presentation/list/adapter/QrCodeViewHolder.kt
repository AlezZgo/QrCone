package com.example.starwarscharacters.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.qrcone.databinding.ItemQrcodeBinding
import com.example.qrcone.presentation.QrCodeUi

class QrCodeViewHolder(
    private val binding: ItemQrcodeBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        qrCode: QrCodeUi,
        onQrCodeClickListener: QrCodeAdapter.OnQrCodeClickListener?,
    ) = with(binding) {

//        titleTextView.text = qrCode.title
//        qrCodeImageView.setImageResource() = qrCode.isFavourite
//
//        tgbFav.setOnClickListener {
//            onIsFavouriteClickListener?.onIsFavouriteClick(character)
//        }
//
//        root.setOnClickListener {
//            onQrCodeClickListener?.onCharacterClick(character)
//        }

    }
}