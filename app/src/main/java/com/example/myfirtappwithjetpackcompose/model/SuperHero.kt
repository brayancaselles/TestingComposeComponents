package com.example.myfirtappwithjetpackcompose.model

import androidx.annotation.DrawableRes

data class SuperHero(
    var superHeroName: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var image: Int,
)
