package com.komala.bkotlin.hilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.komala.bkotlin.R
import com.komala.bkotlin.api.User
import com.komala.bkotlin.hilt.MainAdapter.MyAdapter
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(private val list: ArrayList<User>) : RecyclerView.Adapter<MyAdapter>() {

    class MyAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.name.text = user.name
            itemView.email.text = user.email
            Glide.with(itemView.avatar.context)
                .load(user.avatar)
                .into(itemView.avatar)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter = MyAdapter(
        LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
    )


    override fun onBindViewHolder(holder: MyAdapter, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list?.size
    }
    fun addData(listUsers: List<User>) {
        list.addAll(listUsers)
    }

}