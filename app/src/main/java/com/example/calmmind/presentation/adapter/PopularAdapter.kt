package com.example.calmmind.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.documentfile.R
import androidx.recyclerview.widget.RecyclerView
import com.example.calmmind.business.model.MeditationModel

class PopularAdapter : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    private val popularList = mutableListOf<MeditationModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.calmmind.R.layout.item_popular, parent, false)

        return PopularViewHolder(view)
    }

    override fun getItemCount(): Int = popularList.size

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val popular : MeditationModel = popularList[position]

        holder.nameMeditation.text = popular.nameMeditation
        holder.namePodcast.text = popular.namePodcast
        holder.icon.setImageResource(popular.icon)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(resultPopular : List<MeditationModel>){
        this.popularList.clear()
        this.popularList.addAll(resultPopular)
        notifyDataSetChanged()
    }

    class PopularViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val nameMeditation : TextView = view.findViewById(com.example.calmmind.R.id.tv_popular_name)
        val namePodcast : TextView = view.findViewById(com.example.calmmind.R.id.tv_name_podcast)
        val icon : ImageView = view.findViewById(com.example.calmmind.R.id.icon_popular)
    }
}