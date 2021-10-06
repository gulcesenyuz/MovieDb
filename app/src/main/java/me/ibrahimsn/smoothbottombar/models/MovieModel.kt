package me.ibrahimsn.smoothbottombar.models

import android.os.Parcel
import android.os.Parcelable


data class MovieModel(
    val title: String? ="",
    val poster_path: String? ="",
    val release_date: String? ="",
    val movie_id:Int=0,
    val vote_average:Float= 0.0F,
    val overview: String? =""

)