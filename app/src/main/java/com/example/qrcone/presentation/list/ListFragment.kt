package com.example.qrcone.presentation.list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.qrcone.core.BaseFragment
import com.example.qrcone.databinding.FragmentListBinding
import com.example.qrcone.domain.QrCodeDomain
import com.example.starwarscharacters.presentation.adapter.QrCodeAdapter

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
        }
        setUpAdapter()

    }

    private fun setUpAdapter() {
        val adapter = QrCodeAdapter(
            object : QrCodeAdapter.OnQrCodeClickListener {
                override fun onQrCodeClick(qrCode: QrCodeDomain) {
                    findNavController().navigate(ListFragmentDirections.actionListFragmentToDescriptionFragment(
                        qrCode))
                }


            })
        binding.recyclerview.adapter = adapter

        viewModel.qrCodes.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }


    }

}