package com.mainp.englishdictionaryver2.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionClick
import androidx.recyclerview.widget.RecyclerView
import com.mainp.englishdictionaryver2.R
import com.mainp.englishdictionaryver2.data.model.Word
import com.mainp.englishdictionaryver2.databinding.ItemWordBinding
import com.mainp.englishdictionaryver2.presentation.ui.DictionaryActivity
import com.mainp.englishdictionaryver2.presentation.viewmodel.DictionaryViewModel

class DictionaryAdapter(private var words: List<Word>, private val onDetailClick: (Word) -> Unit, private val onFavoriteClick: (Word) -> Unit) :
    RecyclerView.Adapter<DictionaryAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: ItemWordBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvDetail: ImageView = binding.tvDetail

        val tvFavorite: ImageView = binding.ivStart
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemWordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = words[position]
        holder.binding.word = word
        holder.binding.executePendingBindings()

        holder.tvDetail.setOnClickListener {
            onDetailClick(word)
        }

        holder.tvFavorite.setOnClickListener{
            onFavoriteClick(word)
        }
    }

    override fun getItemCount(): Int = words.size

    fun updateData(newWords: List<Word>) {
        words = newWords
        notifyDataSetChanged()
    }
}
