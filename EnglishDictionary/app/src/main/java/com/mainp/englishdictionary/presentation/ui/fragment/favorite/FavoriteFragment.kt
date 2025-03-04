package com.mainp.englishdictionary.presentation.ui.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mainp.englishdictionary.R
import com.mainp.englishdictionary.data.model.Favorite
import com.mainp.englishdictionary.data.model.Word
import com.mainp.englishdictionary.databinding.FragmentDictionaryBinding
import com.mainp.englishdictionary.databinding.FragmentFavoriteBinding
import com.mainp.englishdictionary.presentation.ui.adapter.DictionaryAdapter
import com.mainp.englishdictionary.presentation.ui.adapter.FavoriteAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var favoriteAdapter: FavoriteAdapter
private lateinit var binding: FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
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
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

       binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val wordList = listOf(
            Favorite("Apple", "aao", "aaa", "aao", "aaa"),
            Favorite("Banana", "aao", "aaa", "aao", "aaa"),
            Favorite("Cat", "aao", "aaa", "aao", "aaa")
        )
        favoriteAdapter = FavoriteAdapter(wordList)

        binding.recyclerView.adapter = favoriteAdapter

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoriteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}