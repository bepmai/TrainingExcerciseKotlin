package com.mainp.englishdictionaryver2.presentation.ui.adapter

import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mainp.englishdictionaryver2.data.model.Favorite
import com.mainp.englishdictionaryver2.data.model.Word
import com.mainp.englishdictionaryver2.databinding.ItemFavoriteBinding
import java.util.Locale

class FavoriteAdapter(
    private var favorites: List<Favorite>,
    private val onDetailClick: (Favorite) -> Unit,
    private val onFavoriteClick: (Favorite) -> Unit,
    private val context: Context) :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    private var textToSpeech: TextToSpeech? = null
    private var originalWords: List<Favorite> = favorites.toList()

    init {
        textToSpeech = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech?.language = Locale.US
            }
        }
    }


    class ViewHolder(var binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root){}

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

        holder.binding.tvDetail.setOnClickListener {
            onDetailClick(favorite)
        }

        holder.binding.ivStart.setOnClickListener{
            onFavoriteClick(favorite)
        }

        val sharedPreferences =
            holder.itemView.context.getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
        val savedSpeed = sharedPreferences.getFloat("speech_rate", 1.0f)
        val fontSize = sharedPreferences.getFloat("font_size", 16f)
        holder.binding.tvNewWord.text = favorite.favId
        holder.binding.tvNewWord.textSize = fontSize

        holder.binding.tvMeanWord.text = favorite.mean
        holder.binding.tvMeanWord.textSize = fontSize


        textToSpeech?.setSpeechRate(savedSpeed)

        holder.binding.ivSound.setOnClickListener {
            val text = favorite.favId
            if (text.isNotEmpty()) {
                textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }
    }

    override fun getItemCount(): Int = favorites.size

    fun updateData(favoriteLists: List<Favorite>) {
        favorites = favoriteLists
        notifyDataSetChanged()
    }
    fun releaseTextToSpeech() {
        textToSpeech?.stop()
        textToSpeech?.shutdown()
    }
}