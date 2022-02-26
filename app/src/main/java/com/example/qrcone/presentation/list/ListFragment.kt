package com.example.qrcone.presentation.list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.qrcone.core.BaseFragment
import com.example.qrcone.databinding.FragmentListBinding

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
//        setUpAdapter()

    }

//    val adapter = CharactersAdapter(
//        object : CharactersAdapter.OnCharacterClickListener {
//            override fun onCharacterClick(character: CharacterInfo) {
//                findNavController().navigate(
//                    CharactersFragmentDirections.actionNavigationCharactersToDescriptionFragment(
//                        character)
//                )
//            }
//        },
//        object : CharactersAdapter.OnIsFavouriteClickListener {
//            override fun onIsFavouriteClick(character: CharacterInfo) {
//                viewModel.changeIsFavouriteStatus(character)
//            }
//        })
//
//    binding.rvCharacters.adapter = adapter
//
//    viewModel.characterList.observe(viewLifecycleOwner) {
//        adapter.submitList(it)
//    }
}