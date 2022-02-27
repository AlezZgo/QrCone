package com.example.qrcone.presentation.description

import android.content.Context
import android.os.Bundle
import android.util.Base64
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.qrcone.R
import com.example.qrcone.core.BaseFragment
import com.example.qrcone.databinding.FragmentDescriptionBinding

class DescriptionFragment : BaseFragment<FragmentDescriptionBinding, DescriptionViewModel>(
    FragmentDescriptionBinding::inflate) {

    private val args by navArgs<DescriptionFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[DescriptionViewModel::class.java]

        with(binding){

            val bytes = Base64.decode(args.qrCode.mediaBase64, Base64.DEFAULT)

            Glide.with(qrCodeImage.context)
                .load(bytes)
                .error(R.drawable.ic_baseline_error_24)
                .placeholder(CircularProgressDrawable(qrCodeImage.context))
                .into(binding.qrCodeImage)

            qrCodeTitle.text = args.qrCode.title
            content.text = args.qrCode.content

        }
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }


}