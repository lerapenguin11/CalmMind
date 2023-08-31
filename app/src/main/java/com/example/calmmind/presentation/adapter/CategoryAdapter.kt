package com.example.calmmind.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calmmind.R
import com.example.calmmind.business.model.CategoryModel

class CategoryAdapter() : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    private val categoryList = mutableListOf<CategoryModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)

        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category : CategoryModel = categoryList[position]

        holder.icon.setImageResource(category.icon)
        holder.title.text = category.title
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(resultCategory : List<CategoryModel>){
        this.categoryList.clear()
        this.categoryList.addAll(resultCategory)
        notifyDataSetChanged()
    }

    class CategoryViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val icon : ImageView = view.findViewById(R.id.ic_category)
        val title : TextView = view.findViewById(R.id.tv_category)
    }
}