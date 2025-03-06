package com.mainp.englishdictionaryver2.presentation.ui.fragment.dictionary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.recyclerview
    .widget.LinearLayoutManager
import com.mainp.englishdictionaryver2.data.model.Word
import com.mainp.englishdictionaryver2.data.repository.DictionaryRepositoryImpl
import com.mainp.englishdictionaryver2.data.room.WordDatabase
import com.mainp.englishdictionaryver2.databinding.FragmentDictionaryBinding
import com.mainp.englishdictionaryver2.presentation.ui.adapter.DictionaryAdapter
import com.mainp.englishdictionaryver2.presentation.viewmodel.DictionaryViewModel
import com.mainp.englishdictionaryver2.presentation.viewmodel.DictionaryViewModelFactory
import androidx.fragment.app.viewModels
import com.mainp.englishdictionaryver2.presentation.ui.DictionaryActivity
import android.util.Base64
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.mainp.englishdictionaryver2.data.dao.FavoriteDao
import com.mainp.englishdictionaryver2.data.model.Favorite
import kotlinx.coroutines.launch
import kotlin.math.log


private lateinit var dictionaryAdapter: DictionaryAdapter
private lateinit var binding: FragmentDictionaryBinding
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DictionaryFragment : Fragment() {
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

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDictionaryBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

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
            }
        )
        binding.recyclerView.adapter = dictionaryAdapter

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

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DictionaryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}