package com.example.starwarscharacters.presentation.adapter

import android.util.Base64
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.qrcone.R
import com.example.qrcone.databinding.ItemQrcodeBinding
import com.example.qrcone.domain.QrCodeDomain
import com.example.qrcone.presentation.QrCodeUi

class QrCodeViewHolder(
    private val binding: ItemQrcodeBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        qrCode: QrCodeDomain,
        onQrCodeClickListener: QrCodeAdapter.OnQrCodeClickListener?,
    ) = with(binding) {

        titleTextView.text = qrCode.title
        contentTextView.text = qrCode.content

        val bytes = Base64.decode(qrCode.mediaBase64, Base64.DEFAULT)

        Glide.with(binding.qrCodeImageView.context)
            .load(bytes)
            .error(R.drawable.ic_baseline_error_24)
            .placeholder(CircularProgressDrawable(qrCodeImageView.context))
            .into(binding.qrCodeImageView)


        root.setOnClickListener {
            onQrCodeClickListener?.onQrCodeClick(qrCode)
        }

    }
}