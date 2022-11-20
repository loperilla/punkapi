package com.loperilla.punkapi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.loperilla.punkapi.databinding.FragmentDetailBinding
import com.loperilla.punkapi.network.model.Beer

class DetailFragment : Fragment() {
    private lateinit var viewRoot: View
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val navArgs: DetailFragmentArgs by navArgs()
    private lateinit var beerSelected: Beer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        viewRoot = binding.root
        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        beerSelected = navArgs.beer
        binding.also {
            Glide
                .with(viewRoot.context)
                .load(beerSelected.image_url)
                .into(it.beerImage)
            it.beerDate.text = beerSelected.firstBrewed
            it.beerName.text = beerSelected.name
            it.beerDescription.text = beerSelected.description
        }
    }
}