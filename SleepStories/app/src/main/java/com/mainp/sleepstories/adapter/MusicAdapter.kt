package com.mainp.sleepstories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.mainp.sleepstories.model.Music
import com.mainp.sleepstories.R

class MusicAdapter(private val music: ArrayList<Music>) : RecyclerView.Adapter<MusicAdapter.ViewHolderClass>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        return ViewHolderClass(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = music[position]
        holder.rvImage.setImageResource(currentItem.img)
        holder.rvName.text = currentItem.name
        holder.rvTime.text = currentItem.time
        holder.rvCategory.text = currentItem.category
    }
    override fun getItemCount(): Int {
        return music.size
    }
    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.IVimage)
        val rvName: TextView = itemView.findViewById(R.id.TVname)
        val rvTime: TextView = itemView.findViewById(R.id.TVtime)
        val rvCategory: TextView = itemView.findViewById(R.id.TVcategory)
    }
}