package com.example.dsgc.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat

data class ApiResponse(
        val events: List<Item>
)
@Parcelize
data class Item(
        val id: Int,
        val datetime_utc: String,
        val venue: Venue,
        val performers: List<Performer>,
): Parcelable
@Parcelize
data class Venue(
        val name:String,
        val address: String,
        val display_location:String
): Parcelable
@Parcelize
data class Performer(
        val image: String
): Parcelable