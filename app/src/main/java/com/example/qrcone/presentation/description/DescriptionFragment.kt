package com.example.qrcone.presentation.description

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qrcone.R
import com.example.qrcone.databinding.FragmentDescriptionBinding
import com.example.qrcone.presentation.BaseFragment

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