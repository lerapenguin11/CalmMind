package com.example.calmmind.business.model

import com.example.calmmind.R

object Constants{

    fun getPopularList() : List<MeditationModel>{
        val popular = listOf(
            MeditationModel(R.string.name_med5, R.string.name_podcast1, R.drawable.ic_med5, R.raw.med_6),
            MeditationModel(R.string.name_med5, R.string.name_podcast1, R.drawable.ic_med5, R.raw.med_6),
            MeditationModel(R.string.name_med6, R.string.name_podcast3, R.drawable.ic_med6, R.raw.med_7),
            MeditationModel(R.string.name_med3, R.string.name_podcast3, R.drawable.ic_med3, R.raw.med_3)
        )

        return popular
    }

    fun getEducationList() : List<MeditationModel>{
        val education = listOf(
            MeditationModel(R.string.name_med5, R.string.name_podcast1, R.drawable.ic_med5, R.raw.med_6),
            MeditationModel(R.string.name_med6, R.string.name_podcast3, R.drawable.ic_med6, R.raw.med_7),
            MeditationModel(R.string.name_med7, R.string.name_podcast2, R.drawable.ic_med1, R.raw.med_8),
            MeditationModel(R.string.name_med8, R.string.name_podcast3, R.drawable.ic_med2, R.raw.med_popular2)
        )

        return education
    }

    fun getDesignList() : List<MeditationModel>{
        val design = listOf(
            MeditationModel(R.string.name_med4, R.string.name_podcast1, R.drawable.ic_med4, R.raw.med_4),
            MeditationModel(R.string.name_med5, R.string.name_podcast1, R.drawable.ic_med5, R.raw.med_6),
            MeditationModel(R.string.name_med6, R.string.name_podcast3, R.drawable.ic_med6, R.raw.med_7),
            MeditationModel(R.string.name_med7, R.string.name_podcast2, R.drawable.ic_med1, R.raw.med_8)
        )

        return design
    }

    fun getArtsList() : List<MeditationModel>{
        val design = listOf(
            MeditationModel(R.string.name_med1, R.string.name_podcast1, R.drawable.ic_med1, R.raw.med_popular1),
            MeditationModel(R.string.name_med2, R.string.name_podcast2, R.drawable.ic_med2, R.raw.med_popular2),
            MeditationModel(R.string.name_med3, R.string.name_podcast3, R.drawable.ic_med3, R.raw.med_3)
        )

        return design
    }

    fun getAllList() : List<MeditationModel>{
        val all = listOf(
            MeditationModel(R.string.name_med1, R.string.name_podcast1, R.drawable.ic_med1, R.raw.med_popular1),
            MeditationModel(R.string.name_med2, R.string.name_podcast2, R.drawable.ic_med2, R.raw.med_popular2),
            MeditationModel(R.string.name_med3, R.string.name_podcast3, R.drawable.ic_med3, R.raw.med_3),
            MeditationModel(R.string.name_med4, R.string.name_podcast1, R.drawable.ic_med4, R.raw.med_4),
            MeditationModel(R.string.name_med5, R.string.name_podcast1, R.drawable.ic_med5, R.raw.med_6),
            MeditationModel(R.string.name_med6, R.string.name_podcast3, R.drawable.ic_med6, R.raw.med_7),
            MeditationModel(R.string.name_med7, R.string.name_podcast2, R.drawable.ic_med1, R.raw.med_8),
            MeditationModel(R.string.name_med8, R.string.name_podcast3, R.drawable.ic_med2, R.raw.med_popular2),
        )

        return all
    }
}