package com.example.qrcone.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.qrcone.presentation.ViewModelFactory
import javax.inject.Inject

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<B : ViewBinding, V : ViewModel>(
    private val inflate: Inflate<B>,
) : Fragment() {

    private var _viewBinding: B? = null
    protected val binding get() = checkNotNull(_viewBinding)

    protected lateinit var viewModel: V

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected val component by lazy {
        (requireActivity().application as QrConeApp).component
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _viewBinding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}