package com.mainp.englishdictionaryver2.presentation.ui.fragment.setting

import android.content.Context
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.mainp.englishdictionaryver2.R
import com.mainp.englishdictionaryver2.databinding.FragmentSettingBinding
import java.util.Locale


class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding

    private var textToSpeech: TextToSpeech? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSettingBinding.inflate(inflater, container, false)

        val sharedPreferences = requireContext().getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
        val savedSpeed = sharedPreferences.getFloat("speech_rate", 1.0f)
        binding.seekBar.progress = (savedSpeed * 50).toInt()

        textToSpeech = TextToSpeech(requireContext()) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech?.language = Locale.US
                textToSpeech?.setSpeechRate(savedSpeed)
            }
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val speed = progress / 50f
                textToSpeech?.setSpeechRate(speed)
                binding.tvSpeed.text = String.format("%.1f", speed)
                val editor = sharedPreferences.edit()
                editor.putFloat("speech_rate", speed)
                editor.apply()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        binding.ivSound.setOnClickListener {
            textToSpeech?.speak("Test sound", TextToSpeech.QUEUE_FLUSH, null, null)
        }

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val fontSize = when (checkedId) {
                R.id.rbSmall -> 12f
                R.id.rbNormal -> 16f
                R.id.rbLarge -> 20f
                R.id.rbExtraLarge -> 24f
                else -> 16f
            }
            sharedPreferences.edit().putFloat("font_size", fontSize).apply()
            updateFontSize(fontSize)
        }
        return binding.root
    }

    private fun updateFontSize(size: Float) {
        binding.tvSpeed.textSize = size
        requireActivity().getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
            .edit()
            .putFloat("font_size", size)
            .apply()
    }

    override fun onDestroy() {
        textToSpeech?.stop()
        textToSpeech?.shutdown()
        super.onDestroy()
    }
}