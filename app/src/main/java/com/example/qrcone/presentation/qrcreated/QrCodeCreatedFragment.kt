package com.example.qrcone.presentation.qrcreated

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.qrcone.R
import com.example.qrcone.core.BaseFragment
import com.example.qrcone.databinding.FragmentCreateBinding
import com.example.qrcone.databinding.FragmentDescriptionBinding
import com.example.qrcone.databinding.FragmentQrcodeCreatedBinding
import com.example.qrcone.presentation.description.DescriptionViewModel

class QrCodeCreatedFragment : BaseFragment<FragmentQrcodeCreatedBinding, QrCodeCreatedViewModel>(
    FragmentQrcodeCreatedBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[QrCodeCreatedViewModel::class.java]

        binding.doneButton.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

}