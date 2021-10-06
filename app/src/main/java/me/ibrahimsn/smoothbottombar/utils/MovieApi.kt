package me.ibrahimsn.smoothbottombar.utils

import me.ibrahimsn.smoothbottombar.models.MovieModel
import me.ibrahimsn.smoothbottombar.response.MovieSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    //search for movie
    @GET("search/movie")
    fun searchMovie(@Query("api_key") key:String,
                    @Query("query") query:String,
                    @Query("page") page:String
    ) : Call<MovieSearchResponse>

    @GET("movie/{movie_id}?")
    fun getMovie(
        @Path("movie_id") movie_id:Int,
        @Query("api_key") api_key:String
    ):Call<MovieModel>


}