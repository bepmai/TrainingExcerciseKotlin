package com.mainp.englishdictionaryver2.presentation.ui

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.Html
import android.text.Spanned
import androidx.appcompat.app.AppCompatActivity
import com.mainp.englishdictionaryver2.databinding.ActivityDictionaryBinding
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import java.util.Locale

class DictionaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDictionaryBinding
    private var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDictionaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val word = intent.getStringExtra("word")
        val av = intent.getByteArrayExtra("av")
        val dnpn = intent.getByteArrayExtra("dnpn")
        val aa = intent.getByteArrayExtra("aa")
        val mean = intent.getStringExtra("mean")

        val sharedPreferences = this.getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
        val savedSpeed = sharedPreferences.getFloat("speech_rate", 1.0f)
        val fontSize = sharedPreferences.getFloat("font_size", 16f)

        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech?.language = Locale.US
                textToSpeech?.setSpeechRate(savedSpeed)
            }
        }

        binding.ivSound.setOnClickListener {
            val text = binding.tvWordTitle.text.toString().trim()
            if (text.isNotEmpty()) {
                textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }

        binding.tvWordTitle.text = word
        binding.tvWordTitle.textSize = fontSize

        binding.tvWord.text = word
        binding.tvWord.textSize = fontSize

        binding.tvMean.text = mean
        binding.tvMean.textSize = fontSize

        av?.let{
            setHtmlText(binding.ivAv,av)
            binding.ivAv.textSize = fontSize
        }
        dnpn?.let{
            setHtmlText(binding.ivDnpn,dnpn)
            binding.ivDnpn.textSize = fontSize
        }
        aa?.let{
            setHtmlText(binding.ivAa,aa)
            binding.ivAa.textSize = fontSize
        }

        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
    fun setHtmlText(textView: TextView, htmlByteArray: ByteArray) {
        val htmlString = htmlByteArray.toString(Charsets.UTF_8)
        val spanned: Spanned = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(htmlString, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(htmlString)
        }
        textView.text = spanned
    }
    override fun onDestroy() {
        textToSpeech?.stop()
        textToSpeech?.shutdown()
        super.onDestroy()
    }
}