package com.example.calmmind.business.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.calmmind.business.model.CategoryModel
import com.example.calmmind.business.model.Constants
import com.example.calmmind.business.model.MeditationModel

class HomeRepository {

    fun getCategoryListReading() : LiveData<MutableList<CategoryModel>> {
        val categoryList = Constants.getCategory()
        val mutableData = MutableLiveData<MutableList<CategoryModel>>()
        val list = mutableListOf<CategoryModel>()

        for (i in categoryList){
            val icon = i.icon
            val title = i.title

            val listCategoryModel = CategoryModel(
                icon = icon, title = title
            )
            list.add(listCategoryModel)
        }

        mutableData.value = list

        return mutableData
    }

    fun getPopularListReading() : LiveData<MutableList<MeditationModel>> {
        val popularList = Constants.getPopular()
        val mutableData = MutableLiveData<MutableList<MeditationModel>>()
        val list = mutableListOf<MeditationModel>()

        for (i in popularList){
            val icon = i.icon
            val nameMeditation = i.nameMeditation
            val namePodcast = i.namePodcast
            val music = i.music

            val listCategoryModel = MeditationModel(
                icon = icon, nameMeditation = nameMeditation, namePodcast = namePodcast, music = music
            )
            list.add(listCategoryModel)
        }

        mutableData.value = list

        return mutableData
    }
}