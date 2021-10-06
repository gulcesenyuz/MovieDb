package me.ibrahimsn.smoothbottombar.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import me.ibrahimsn.smoothbottombar.models.MovieModel

//get multiple movie list- popular movies
class MovieSearchResponse{
    @SerializedName("total_results")
    @Expose
    private val total_count:Int=0

    @SerializedName("results")
    @Expose
    private val movies:List<MovieModel> = emptyList()

    public fun getTotal_count():Int{
        return total_count;
    }
    public fun getMovies():List<MovieModel>{
        return movies
    }
    @Override
    public override fun toString():String{
        return "MovieSearchResponse{" + "total_count" + total_count+
                ", movies=  " + movies + "}"
    }


}