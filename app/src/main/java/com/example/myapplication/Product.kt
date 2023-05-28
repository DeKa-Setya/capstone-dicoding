package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val photo: Int,
    val name: String,
    val price: String
) : Parcelable
