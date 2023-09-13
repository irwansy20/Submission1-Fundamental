package com.example.githubuser

import android.content.Intent
import android.media.browse.MediaBrowser
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubuser.MoveActivity.Companion.EXTRA_USER
import com.example.githubuser.databinding.ItemUserBinding

class ListUserAdapter(private val listUser: ArrayList<User>): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemCallback

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (user, follow, following, photo) = listUser[position]
        Glide.with(holder.binding.imgPhoto)
            .load(photo)
            .circleCrop()
            .into(holder.binding.imgPhoto)
        holder.binding.tvName.text = user
        holder.binding.tvFollower.text = follow
        holder.binding.tvFollowing.text = following

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
        }
    }
    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    fun setOnClickCallback(onItemCallback: OnItemCallback){
        this.onItemClickCallback = onItemCallback
    }

    interface OnItemCallback{
        fun onItemClicked(user:User)
    }
}