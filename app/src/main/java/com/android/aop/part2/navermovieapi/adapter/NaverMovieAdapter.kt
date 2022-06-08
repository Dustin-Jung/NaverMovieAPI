package com.android.aop.part2.navermovieapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.aop.part2.navermovieapi.api.Item
import com.android.aop.part2.navermovieapi.databinding.NaverItemBinding

class NaverMovieAdapter : RecyclerView.Adapter<NaverMovieViewHolder>() {

    private val itemList = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NaverMovieViewHolder {

        val binding = NaverItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NaverMovieViewHolder(binding)

    }

    override fun onBindViewHolder(holder: NaverMovieViewHolder, position: Int) {

        holder.bind(itemList[position])

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addAll(list: List<Item>){
        itemList.addAll(list)
        notifyDataSetChanged()

    }
}

class NaverMovieViewHolder(private val binding: NaverItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.item = item
    }
}


