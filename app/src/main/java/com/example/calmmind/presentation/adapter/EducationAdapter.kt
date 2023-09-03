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

class EducationAdapter(val listener : PopularListener, private var educationList: List<MeditationModel>) : RecyclerView.Adapter<EducationAdapter.EducationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.calmmind.R.layout.item_med_category, parent, false)

        return EducationViewHolder(view)
    }

    override fun getItemCount(): Int = educationList.size

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        val popular : MeditationModel = educationList[position]

        holder.nameMeditation.setText(popular.nameMeditation)
        holder.namePodcast.setText(popular.namePodcast)
        holder.icon.setImageResource(popular.icon)

        holder.itemView.setOnClickListener {
            listener.popularList(popular)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(resultEducation : List<MeditationModel>){
        educationList = resultEducation
        notifyDataSetChanged()
    }

    class EducationViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val nameMeditation : TextView = view.findViewById(com.example.calmmind.R.id.tv_category_name)
        val namePodcast : TextView = view.findViewById(com.example.calmmind.R.id.tv_name_podcast_category)
        val icon : ImageView = view.findViewById(com.example.calmmind.R.id.icon_med_category)
    }
}