package com.example.qrcone.presentation.create

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.esafirm.imagepicker.features.ImagePickerConfig
import com.esafirm.imagepicker.features.ImagePickerMode
import com.esafirm.imagepicker.features.registerImagePicker
import com.example.qrcone.core.BaseFragment
import com.example.qrcone.databinding.FragmentCreateBinding

class CreateFragment : BaseFragment<FragmentCreateBinding, CreateViewModel>(
    FragmentCreateBinding::inflate) {

//    private lateinit var imagePicker: ImagePickerLauncher
//    private lateinit var config: ImagePickerConfig


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this, viewModelFactory)[CreateViewModel::class.java]

        val config = ImagePickerConfig {
            mode = ImagePickerMode.SINGLE
        }

        val imagePicker = registerImagePicker {
//            viewModel.path = it.first().path
            binding.pathTextView.text.insert(0, it.first().path)
        }

        binding.chooseFileImage.setOnClickListener {
            imagePicker.launch(config)
        }

        binding.createQrCodeButton.setOnClickListener {
            findNavController().navigate(
                CreateFragmentDirections.actionCreateFragmentToQrCodeCreatedFragment()
            )
        }

    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

}