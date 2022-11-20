package com.loperilla.punkapi.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.loperilla.punkapi.databinding.BeerItemBinding
import com.loperilla.punkapi.network.model.Beer

class BeersAdapter(
    private val beerList: List<Beer>,
    private val onItemClick: (Beer) -> Unit
) : RecyclerView.Adapter<BeersAdapter.BeerItemVH>() {
    private lateinit var viewRoot: View
    private var _binding: BeerItemBinding? = null
    private val binding get() = _binding!!
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerItemVH {
        _binding = BeerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        viewRoot = binding.root
        return BeerItemVH(binding)
    }

    override fun onBindViewHolder(holder: BeerItemVH, position: Int) {
        with(beerList[position]) {
            binding.also {
                it.beerName.text = this.name
                it.beerName.setOnClickListener {
                    onItemClick(this)
                }
            }
        }

    }

    override fun getItemCount() = beerList.size

    inner class BeerItemVH(binding: BeerItemBinding) : ViewHolder(binding.root)
}