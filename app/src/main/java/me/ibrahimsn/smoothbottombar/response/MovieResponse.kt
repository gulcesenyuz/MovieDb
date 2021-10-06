package me.ibrahimsn.smoothbottombar.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import me.ibrahimsn.smoothbottombar.models.MovieModel

//single movie
class MovieResponse {
    @SerializedName("results")
    @Expose
    val movie: MovieModel? = null
}