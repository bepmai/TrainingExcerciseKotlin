package com.mainp.sleepstories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.mainp.sleepstories.model.Menu
import com.mainp.sleepstories.R
import com.mainp.sleepstories.databinding.ItemMenuBinding
import com.mainp.sleepstories.databinding.ItemMusicBinding

class MenuAdapter(private val menu: ArrayList<Menu>) : RecyclerView.Adapter<MenuAdapter.ViewHolderClass>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        return ViewHolderClass(ItemMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }
    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = menu[position]
        holder.binding.item = currentItem
//        if (currentItem is CardView) {
//            val cardView = holder.itemView as CardView
//            if (position in listOf(1, 2, 3, 4)) {
//                cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context,
//                    R.color.deepPurple_A200
//                ))
//            } else {
//                cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context,
//                    R.color.indigo_400
//                ))
//            }
//        }
    }
    override fun getItemCount(): Int {
        return menu.size
    }
    class ViewHolderClass(val binding: ItemMenuBinding): RecyclerView.ViewHolder(binding.root)
}