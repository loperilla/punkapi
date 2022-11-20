package com.loperilla.punkapi.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.loperilla.punkapi.databinding.ListFragmentBinding
import com.loperilla.punkapi.ui.viewmodel.BeerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {
    private lateinit var viewRoot: View
    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    /**
     * El número de página que voy a solicitar a la api
     */
    private var nPages = 1
    private val beersViewModel: BeerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        viewRoot = binding.root
        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        binding.also {
            it.searchInput.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    //
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    beersViewModel.loadBeers(nPages, p0.toString())
                }

                override fun afterTextChanged(p0: Editable?) {
                    //
                }
            })

            it.buttonTest.setOnClickListener {
                findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToDetailFragment("Estrella Galicia")
                )
            }
        }
    }

    private fun setUpObservers() {
        beersViewModel.getBeersLiveData().observe(viewLifecycleOwner) { beerList ->
            beerList.forEach { beer ->
                Log.e("beerLivedata", "$beer")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        beersViewModel.getRandom()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}