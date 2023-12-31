package com.example.calmmind.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calmmind.business.model.MeditationModel
import com.example.calmmind.presentation.listener.PopularListener

class PopularAdapter(val listener : PopularListener, private var popularList: List<MeditationModel>) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    //private val popularList = mutableListOf<MeditationModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.calmmind.R.layout.item_popular, parent, false)

        return PopularViewHolder(view)
    }

    override fun getItemCount(): Int = popularList.size

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val popular : MeditationModel = popularList[position]

        holder.nameMeditation.setText(popular.nameMeditation)
        holder.namePodcast.setText(popular.namePodcast)
        holder.icon.setImageResource(popular.icon)

        holder.itemView.setOnClickListener {
            listener.popularList(popular)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(resultPopular : List<MeditationModel>){
        popularList = resultPopular
        notifyDataSetChanged()
    }

    class PopularViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val nameMeditation : TextView = view.findViewById(com.example.calmmind.R.id.tv_popular_name)
        val namePodcast : TextView = view.findViewById(com.example.calmmind.R.id.tv_name_podcast)
        val icon : ImageView = view.findViewById(com.example.calmmind.R.id.icon_popular)
    }
}