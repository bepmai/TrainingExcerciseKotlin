package com.mainp.englishdictionaryver2.presentation.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mainp.englishdictionaryver2.R
import com.mainp.englishdictionaryver2.data.model.Word
import com.mainp.englishdictionaryver2.databinding.ActivityDictionaryBinding
import com.mainp.englishdictionaryver2.databinding.ActivityMainBinding
import com.mainp.englishdictionaryver2.presentation.ui.adapter.DictionaryAdapter
import android.util.Base64
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.mainp.englishdictionaryver2.data.repository.DictionaryRepositoryImpl
import com.mainp.englishdictionaryver2.data.room.WordDatabase
import com.mainp.englishdictionaryver2.presentation.viewmodel.DictionaryViewModel
import com.mainp.englishdictionaryver2.presentation.viewmodel.DictionaryViewModelFactory


class DictionaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDictionaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDictionaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val word = intent.getStringExtra("word")
        val av = intent.getByteArrayExtra("av")
        val dnpn = intent.getByteArrayExtra("dnpn")
        val aa = intent.getByteArrayExtra("aa")
        val mean = intent.getStringExtra("mean")

        Log.d("DictionaryActivity", "Received word: $word")


        binding.tvWord.text = word
        binding.tvMean.text = mean

        av?.let{
            setHtmlText(binding.ivAv,av)
        }
        dnpn?.let{
            setHtmlText(binding.ivDnpn,dnpn)
        }
        aa?.let{
            setHtmlText(binding.ivAa,aa)
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
}