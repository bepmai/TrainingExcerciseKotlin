package com.mainp.englishdictionaryver2.presentation.ui.fragment.favorite

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mainp.englishdictionaryver2.data.repository.DictionaryRepositoryImpl
import com.mainp.englishdictionaryver2.data.room.WordDatabase
import com.mainp.englishdictionaryver2.databinding.FragmentFavoriteBinding
import com.mainp.englishdictionaryver2.presentation.ui.DictionaryActivity
import com.mainp.englishdictionaryver2.presentation.ui.adapter.FavoriteAdapter
import com.mainp.englishdictionaryver2.presentation.viewmodel.DictionaryViewModel
import com.mainp.englishdictionaryver2.presentation.viewmodel.DictionaryViewModelFactory

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var favoriteAdapter: FavoriteAdapter

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
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        favoriteAdapter = FavoriteAdapter(emptyList(), onDetailClick = { favorite ->
            val intent = Intent(requireContext(), DictionaryActivity::class.java).apply {
                putExtra("word", favorite.favId)
                putExtra("av", favorite.av)
                putExtra("dnpn", favorite.dnpn)
                putExtra("aa", favorite.aa)
                putExtra("mean", favorite.mean)
            }
            startActivity(intent)
        },
            onFavoriteClick = { favorite -> (favorite)
                viewModel.deleteFavorite(favorite)
                Toast.makeText(requireContext(), "Đã xoa", Toast.LENGTH_SHORT).show()
            },
            context = requireContext()
        )
        binding.recyclerView.adapter = favoriteAdapter

        viewModel.factory.observe(viewLifecycleOwner) { favoriteList ->
            favoriteAdapter.updateData(favoriteList)
        }
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        favoriteAdapter.releaseTextToSpeech()
    }
}
