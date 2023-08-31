package com.example.calmmind.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calmmind.business.model.CategoryModel
import com.example.calmmind.business.model.MeditationModel
import com.example.calmmind.business.repos.HomeRepository

class HomeViewModel : ViewModel() {

    private val repository = HomeRepository()

    fun getCategory() : LiveData<MutableList<CategoryModel>> {
        val mutableData = MutableLiveData<MutableList<CategoryModel>>()
        repository.getCategoryListReading().observeForever {list ->
            mutableData.value = list
        }

        return mutableData
    }

    fun getPopular() : LiveData<MutableList<MeditationModel>> {
        val mutableData = MutableLiveData<MutableList<MeditationModel>>()
        repository.getPopularListReading().observeForever {list ->
            mutableData.value = list
        }

        return mutableData
    }
}