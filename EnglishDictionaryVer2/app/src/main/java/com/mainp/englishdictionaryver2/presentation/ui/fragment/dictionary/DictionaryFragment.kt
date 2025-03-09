package com.mainp.englishdictionaryver2.presentation.ui.fragment.dictionary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mainp.englishdictionaryver2.data.model.Word
import com.mainp.englishdictionaryver2.data.repository.DictionaryRepositoryImpl
import com.mainp.englishdictionaryver2.data.room.WordDatabase
import com.mainp.englishdictionaryver2.databinding.FragmentDictionaryBinding
import com.mainp.englishdictionaryver2.presentation.ui.adapter.DictionaryAdapter
import com.mainp.englishdictionaryver2.presentation.viewmodel.DictionaryViewModel
import com.mainp.englishdictionaryver2.presentation.viewmodel.DictionaryViewModelFactory
import androidx.fragment.app.viewModels
import com.mainp.englishdictionaryver2.presentation.ui.DictionaryActivity
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import com.mainp.englishdictionaryver2.data.model.Favorite

class DictionaryFragment : Fragment() {
    private lateinit var dictionaryAdapter: DictionaryAdapter
    private lateinit var binding: FragmentDictionaryBinding

    private val viewModel by viewModels<DictionaryViewModel> {
        DictionaryViewModelFactory(
            DictionaryRepositoryImpl(
                WordDatabase.getDatabase(requireContext())!!
                    .wordDao(),
                WordDatabase.getDatabase(requireContext())!!
                    .favoriteDao(),
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDictionaryBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(requireContext())

//        viewModel.words.observe(viewLifecycleOwner) { wordList ->
//            Log.d("FragmentDictionary", "Danh sách từ: $wordList")
//            dictionaryAdapter.updateData(wordList)
//        }


        dictionaryAdapter = DictionaryAdapter(emptyList(),
            onDetailClick = { word ->
                val intent = Intent(requireContext(), DictionaryActivity::class.java).apply {
                    putExtra("word", word.word)
                    putExtra("av", word.av)
                    putExtra("dnpn", word.dnpn)
                    putExtra("aa", word.aa)
                    putExtra("mean", word.mean)
                }
                startActivity(intent)
            },
            onFavoriteClick = { word ->
                addToFavorite(word)
            },
            context = requireContext(),
        )
        binding.recyclerView.adapter = dictionaryAdapter

        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                dictionaryAdapter.filterList(newText.orEmpty())
                return true
            }
        })
        viewModel.words.observe(viewLifecycleOwner) { wordList ->
            dictionaryAdapter.updateData(wordList)
        }

        return binding.root
    }

    private fun addToFavorite(word: Word) {
        val favorite = Favorite(
            favId = word.word,
            av = word.av,
            dnpn = word.dnpn,
            aa = word.aa,
            mean = word.mean
        )

        viewModel.insertFavorite(favorite)
        Toast.makeText(requireContext(), "Đã thêm vào danh sách yêu thích", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        dictionaryAdapter.releaseTextToSpeech()
    }
}