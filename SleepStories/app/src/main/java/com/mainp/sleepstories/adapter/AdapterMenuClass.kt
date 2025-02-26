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

class AdapterMenuClass(private val menu: ArrayList<Menu>) : RecyclerView.Adapter<AdapterMenuClass.ViewHolderClass>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return ViewHolderClass(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = menu[position]
        holder.rvImage.setImageResource(currentItem.icon)
        holder.rvTitle.text = currentItem.title

        if (holder.itemView is CardView) {
            val cardView = holder.itemView as CardView
            if (position in listOf(1, 2, 3, 4)) {
                cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context,
                    R.color.deepPurple_A200
                ))
            } else {
                cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context,
                    R.color.indigo_400
                ))
            }
        }
    }
    override fun getItemCount(): Int {
        return menu.size
    }
    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.IVimage)
        val rvTitle: TextView = itemView.findViewById(R.id.TVtitle)
    }
}