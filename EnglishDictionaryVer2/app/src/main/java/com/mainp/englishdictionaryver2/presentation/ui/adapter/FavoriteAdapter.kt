package com.mainp.englishdictionaryver2.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mainp.englishdictionaryver2.data.model.Favorite
import com.mainp.englishdictionaryver2.data.model.Word
import com.mainp.englishdictionaryver2.databinding.ItemFavoriteBinding

class FavoriteAdapter(private var favorites: List<Favorite>, private val onDetailClick: (Favorite) -> Unit, private val onFavoriteClick: (Favorite) -> Unit) :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root){
        val tvDetail: ImageView = binding.tvDetail

        val ivStart: ImageView = binding.ivStart
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFavoriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favorite = favorites[position]
        holder.binding.favorite = favorite
        holder.binding.executePendingBindings()

        holder.tvDetail.setOnClickListener {
            onDetailClick(favorite)
        }

        holder.ivStart.setOnClickListener{
            onFavoriteClick(favorite)
        }
    }

    override fun getItemCount(): Int = favorites.size

    fun updateData(favoriteLists: List<Favorite>) {
        favorites = favoriteLists
        notifyDataSetChanged()
    }
}