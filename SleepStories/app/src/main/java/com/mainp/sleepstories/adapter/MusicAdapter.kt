package com.mainp.sleepstories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import androidx.databinding.DataBindingUtil
import com.mainp.sleepstories.model.Music
import com.mainp.sleepstories.R
import com.mainp.sleepstories.databinding.ItemMusicBinding

class MusicAdapter(private val music: ArrayList<Music>) :
    RecyclerView.Adapter<MusicAdapter.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        return ViewHolderClass(
            ItemMusicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = music[position]
        holder.binding.item = currentItem
    }

    override fun getItemCount(): Int {
        return music.size
    }

    class ViewHolderClass(val binding: ItemMusicBinding) : RecyclerView.ViewHolder(binding.root)
}