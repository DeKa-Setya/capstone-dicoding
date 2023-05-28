package com.example.myapplication.ui.Cart

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Ikan(
    val gambar: Int,
    val ikan: String,
    val harga: String
) : Parcelable