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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

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
            }
        )

        binding.recyclerview.adapter = adapter

        viewModel.fetchQrCodes()

        viewModel.observeList(viewLifecycleOwner) {
            if(it.isEmpty()){
                binding.cachedListProgressBar.visibility = View.GONE
                binding.fragmentEmptyList.visibility = View.VISIBLE
            }else{
                binding.cachedListProgressBar.visibility = View.GONE
                binding.recyclerview.visibility = View.VISIBLE
                adapter.submitList(it)
            }

        }

        setupSwipeListener(adapter)

    }

    private fun setupSwipeListener(adapter: QrCodeAdapter) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = adapter.currentList[viewHolder.adapterPosition]
                CoroutineScope(Dispatchers.IO + Job()).launch {
                    viewModel.delete(item)
                }
            }

        }

        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.recyclerview)

    }

}