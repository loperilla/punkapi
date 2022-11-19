package com.loperilla.punkapi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.loperilla.punkapi.databinding.ListFragmentBinding

class ListFragment: Fragment() {
    private lateinit var viewRoot: View
    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        viewRoot = binding.root
        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.also {
            it.buttonTest.setOnClickListener {
                findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToDetailFragment("Estrella Galicia")
                )
            }
        }
    }
}