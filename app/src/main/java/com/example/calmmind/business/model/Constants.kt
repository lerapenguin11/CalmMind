package com.example.calmmind.business.model

import android.widget.PopupMenu
import com.example.calmmind.R

object Constants{

    fun getCategory() : MutableList<CategoryModel> {
        val categoryList = mutableListOf<CategoryModel>()

        val category1 = CategoryModel("Education", R.drawable.ic_defolt)
        categoryList.add(category1)

        val category2 = CategoryModel("Design", R.drawable.ic_category2)
        categoryList.add(category2)

        val category3 = CategoryModel("Arts", R.drawable.ic_category3)
        categoryList.add(category3)

        val category4 = CategoryModel("Nature", R.drawable.ic_category4)
        categoryList.add(category4)

        val category5 = CategoryModel("Dream", R.drawable.ic_category5)
        categoryList.add(category5)

        val category6 = CategoryModel("Sport", R.drawable.ic_categoty1)
        categoryList.add(category6)

        return categoryList
    }

    fun getPopular() : MutableList<MeditationModel>{
        val popularList = mutableListOf<MeditationModel>()

        val popular1 = MeditationModel("Unbeaten", "Podcast by Vladimir", R.drawable.ic_med1)
        popularList.add(popular1)

        return popularList
    }
}