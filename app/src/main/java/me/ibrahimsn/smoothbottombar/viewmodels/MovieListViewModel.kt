package me.ibrahimsn.smoothbottombar.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.ibrahimsn.smoothbottombar.models.MovieModel
import me.ibrahimsn.smoothbottombar.repositories.MovieRepository

class MovieListViewModel:ViewModel() {

    private val movieRepository:MovieRepository?=MovieRepository().getInstance()

    public fun getMovies():LiveData<List<MovieModel>>{
        return movieRepository!!.getMovies()
    }

}