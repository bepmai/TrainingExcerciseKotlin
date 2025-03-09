package com.mainp.englishdictionaryver2.presentation.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.mainp.englishdictionaryver2.R
import com.mainp.englishdictionaryver2.databinding.ActivityMainBinding
import com.mainp.englishdictionaryver2.presentation.ui.fragment.dictionary.DictionaryFragment
import com.mainp.englishdictionaryver2.presentation.ui.fragment.favorite.FavoriteFragment
import com.mainp.englishdictionaryver2.presentation.ui.fragment.game.GameFragment
import com.mainp.englishdictionaryver2.presentation.ui.fragment.setting.SettingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        replaceFragment(DictionaryFragment())


        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.dictionary -> replaceFragment(DictionaryFragment())
                R.id.favorite -> replaceFragment(FavoriteFragment())
                R.id.game -> replaceFragment(GameFragment())
                R.id.setting -> replaceFragment(SettingFragment())
                else -> {
                }
            }
            true
        }

        if (savedInstanceState == null) {
            replaceFragment(DictionaryFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, fragment)
            .addToBackStack(null)
            .commit()
    }
}