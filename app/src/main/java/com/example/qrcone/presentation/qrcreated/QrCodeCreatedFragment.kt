package com.example.qrcone.presentation.qrcreated

import android.content.Context
import android.os.Bundle
import android.util.Base64
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.qrcone.R
import com.example.qrcone.core.BaseFragment
import com.example.qrcone.databinding.FragmentQrcodeCreatedBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class QrCodeCreatedFragment : BaseFragment<FragmentQrcodeCreatedBinding, QrCodeCreatedViewModel>(
    FragmentQrcodeCreatedBinding::inflate) {

    private val args by navArgs<QrCodeCreatedFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[QrCodeCreatedViewModel::class.java]

        binding.doneButton.setOnClickListener {
            findNavController().navigateUp()
        }

        CoroutineScope(Dispatchers.IO + Job()).launch {
            try {

                val qrCode = viewModel.generateQrCode(args.qrCodeRequest)

                activity?.runOnUiThread {
                    binding.progressBar.visibility = View.GONE
                    binding.constraintLayout.visibility = View.VISIBLE
                    binding.createdQrCodeTitle.text = qrCode.title
                    binding.createdQrCodeContent.text = qrCode.content

                    val bytes = Base64.decode(qrCode.mediaBase64, Base64.DEFAULT)

                    Glide.with(binding.createdQrCodeImage.context)
                        .load(bytes)
                        .error(R.drawable.ic_baseline_error_24)
                        .placeholder(CircularProgressDrawable(binding.createdQrCodeImage.context))
                        .into(binding.createdQrCodeImage)
                }

            } catch (e: Exception) {
                activity?.runOnUiThread {
                    binding.progressBar.visibility = View.GONE
                    binding.constraintLayout.visibility = View.VISIBLE
                    binding.createdQrCodeTitle.text = e.message
                    binding.createdQrCodeContent.text = ""

                    Glide.with(binding.createdQrCodeImage.context)
                        .load(R.drawable.ic_baseline_error_24)
                        .into(binding.createdQrCodeImage)
                }
            }

        }


    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

}