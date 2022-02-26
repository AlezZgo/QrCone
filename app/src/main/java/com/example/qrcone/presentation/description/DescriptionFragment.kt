package com.example.qrcone.presentation.description

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.qrcone.core.BaseFragment
import com.example.qrcone.databinding.FragmentDescriptionBinding

class DescriptionFragment : BaseFragment<FragmentDescriptionBinding, DescriptionViewModel>(
    FragmentDescriptionBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[DescriptionViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }


}