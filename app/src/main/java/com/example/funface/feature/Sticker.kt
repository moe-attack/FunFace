package com.example.funface.feature

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sticker (
    val identifier: Int,
    val imageFileName: String,
    val emojis: List<String>,
    val size: Long
) : Parcelable