package com.komala.bkotlin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.komala.bkotlin.R
import com.komala.bkotlin.ui.adapter.KConceptsAdapter.*

class KConceptsAdapter(
    private val listConcetps: List<String>,
    private val listener: OnKConceptClickedListener
) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_concept, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(listConcetps[position])
    }

    override fun getItemCount(): Int {
        return listConcetps.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvConcept: TextView = view.findViewById(R.id.tv_kconcept)
        fun bindData(concept: String) {
            tvConcept.text = concept
        }

        init {
            view.setOnClickListener { listener.onKConceptClicked(listConcetps.get(adapterPosition)) }
        }
    }

    interface OnKConceptClickedListener {
        fun onKConceptClicked(concept: String)
    }

}