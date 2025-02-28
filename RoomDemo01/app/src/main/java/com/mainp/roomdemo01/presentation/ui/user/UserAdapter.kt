package com.mainp.roomdemo01.presentation.ui.user

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.mainp.roomdemo01.data.model.User
import android.view.ViewGroup
import com.mainp.roomdemo01.databinding.ItemUserBinding

class UserAdapter(private val users: List<User>, private val onUserClick: (User) -> Unit) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)

        holder.itemView.setOnClickListener {
            onUserClick(user)
        }
    }

    override fun getItemCount(): Int = users.size

    class UserViewHolder(var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.itemUser = user
            binding.executePendingBindings()
        }
    }
}
