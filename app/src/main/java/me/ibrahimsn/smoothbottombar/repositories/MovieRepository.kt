package me.ibrahimsn.smoothbottombar.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.ibrahimsn.smoothbottombar.models.MovieModel

class MovieRepository {
    //LiveData
    var mMovies= MutableLiveData<List<MovieModel>>()
    private var instance: MovieRepository? = null

    fun getInstance(): MovieRepository? {
        if (instance == null) {
            instance = MovieRepository()
        }
        return instance
    }



    fun getMovies():LiveData<List<MovieModel>>{
        return mMovies
    }
}