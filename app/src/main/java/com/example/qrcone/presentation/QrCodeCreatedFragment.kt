package com.example.qrcone.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qrcone.R

class QrCodeCreatedFragment : Fragment() {

    companion object {
        fun newInstance() = QrCodeCreatedFragment()
    }

    private lateinit var viewModel: QrCodeCreatedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_qrcode_created, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QrCodeCreatedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}