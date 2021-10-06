package me.ibrahimsn.smoothbottombar.request

import me.ibrahimsn.smoothbottombar.utils.Credentials
import me.ibrahimsn.smoothbottombar.utils.MovieApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url

class Service {

    companion object{

        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Credentials.BASE_URL)
            .build()

        var movieApi: MovieApi = retrofit.create(MovieApi::class.java)

        @JvmName("getMovieApi1")
        fun getMovieApi():MovieApi{
            println("movieApi  $movieApi")
            return movieApi
        }


    }


}