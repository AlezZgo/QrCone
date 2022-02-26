package com.example.qrcone.presentation.list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.qrcone.databinding.FragmentListBinding
import com.example.qrcone.presentation.BaseFragment

class ListFragment :
    BaseFragment<FragmentListBinding, ListViewModel>(FragmentListBinding::inflate) {

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[ListViewModel::class.java]

        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(ListFragmentDirections.actionListFragmentToCreateFragment())
            //setUpAdapter()


        }


    }
}