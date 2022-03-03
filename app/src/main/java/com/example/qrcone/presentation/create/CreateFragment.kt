package com.example.qrcone.presentation.create

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.esafirm.imagepicker.features.ImagePickerConfig
import com.esafirm.imagepicker.features.ImagePickerMode
import com.esafirm.imagepicker.features.registerImagePicker
import com.example.qrcone.R
import com.example.qrcone.core.BaseFragment
import com.example.qrcone.databinding.FragmentCreateBinding
import com.example.qrcone.domain.QrCodeRequest
import dev.sasikanth.colorsheet.ColorSheet
import okhttp3.internal.toHexString

class CreateFragment : BaseFragment<FragmentCreateBinding, CreateViewModel>(
    FragmentCreateBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[CreateViewModel::class.java]

        val launcher = registerImagePicker {
            viewModel.imagePath = it.first().path
            binding.pathTextView.text.append(viewModel.imagePath)
        }

        binding.chooseFileImage.setOnClickListener {
            launcher.launch(ImagePickerConfig {
                mode = ImagePickerMode.SINGLE
            })
        }

        binding.colorPickerButton.setOnClickListener {
            ColorSheet().colorPicker(
                colors = resources.getIntArray(R.array.bottom_sheet_colors),
                listener = { color ->
                    binding.qrCodePreviewImage.setColorFilter(color)
                    viewModel.currentColor = color.toString()
                })
                .show(requireActivity().supportFragmentManager)
        }

        binding.createQrCodeButton.setOnClickListener {

            findNavController().navigate(
                CreateFragmentDirections.actionCreateFragmentToQrCodeCreatedFragment(
                    QrCodeRequest(
                        title = binding.titleCreate.text.toString(),
                        color = viewModel.currentColor.toInt().toHexString().removeRange(0, 1)
                            .chunked(2).joinToString(","),
                        content = binding.contentCreate.text.toString(),
                        mediaPath = viewModel.imagePath.toString()
                    )
                )
            )
        }
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

}