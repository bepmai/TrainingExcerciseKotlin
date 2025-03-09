package com.mainp.englishdictionaryver2.presentation.ui.adapter

import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.mainp.englishdictionaryver2.data.model.Word
import com.mainp.englishdictionaryver2.databinding.ItemWordBinding
import java.util.Locale

class DictionaryAdapter(
    private var words: List<Word>,
    private val onDetailClick: (Word) -> Unit,
    private val onFavoriteClick: (Word) -> Unit,
    private val context: Context
) :
    RecyclerView.Adapter<DictionaryAdapter.ViewHolder>() {

    private var textToSpeech: TextToSpeech? = null
    private var originalWords: List<Word> = words.toList()

    init {
        textToSpeech = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech?.language = Locale.US
            }
        }
    }

    class ViewHolder(var binding: ItemWordBinding) : RecyclerView.ViewHolder(binding.root) {}

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

        holder.binding.tvDetail.setOnClickListener {
            onDetailClick(word)
        }

        holder.binding.ivStart.setOnClickListener{
            onFavoriteClick(word)
        }

        val sharedPreferences =
            holder.itemView.context.getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
        val savedSpeed = sharedPreferences.getFloat("speech_rate", 1.0f)
        val fontSize = sharedPreferences.getFloat("font_size", 16f)
        holder.binding.tvNewWord.text = word.word
        holder.binding.tvNewWord.textSize = fontSize

        holder.binding.tvMeanWord.text = word.mean
        holder.binding.tvMeanWord.textSize = fontSize


        textToSpeech?.setSpeechRate(savedSpeed)

        holder.binding.ivSound.setOnClickListener {
            val text = word.word
            if (text.isNotEmpty()) {
                textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }
    }

    override fun getItemCount(): Int = words.size

    fun filterList(query: String) {
        words = if (query.isEmpty()) {
            originalWords
        } else {
            originalWords.filter { it.word.contains(query, ignoreCase = true) }
        }
        notifyDataSetChanged()
    }

    fun updateData(newWords: List<Word>) {
        words = newWords
        originalWords = newWords.toList()
        notifyDataSetChanged()
    }

    fun releaseTextToSpeech() {
        textToSpeech?.stop()
        textToSpeech?.shutdown()
    }
}
