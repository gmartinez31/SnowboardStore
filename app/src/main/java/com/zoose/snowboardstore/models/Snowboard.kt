package com.zoose.snowboardstore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Snowboard(
    var name: String,
    var size: Int,
    var brand: String,
    var description: String,
    var images: List<String> = mutableListOf()) : Parcelable