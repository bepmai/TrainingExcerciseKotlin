package com.mainp.englishdictionary.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mainp.englishdictionary.data.model.Word
import com.mainp.englishdictionary.databinding.ItemWordBinding

class DictionaryAdapter(private val words: List<Word>) :
    RecyclerView.Adapter<DictionaryAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemWordBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemWordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = words[position]
        holder.binding.word = word
    }

    override fun getItemCount(): Int = words.size
}