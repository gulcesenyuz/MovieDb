package me.ibrahimsn.smoothbottombar.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import me.ibrahimsn.smoothbottombar.databinding.FragmentHomeBinding
import me.ibrahimsn.smoothbottombar.models.MovieModel
import me.ibrahimsn.smoothbottombar.request.Service
import me.ibrahimsn.smoothbottombar.response.MovieSearchResponse
import me.ibrahimsn.smoothbottombar.utils.Credentials
import me.ibrahimsn.smoothbottombar.utils.MovieApi
import me.ibrahimsn.smoothbottombar.viewmodels.MovieListViewModel
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private  var _binding: FragmentHomeBinding?=null
    private val binding get()=_binding!!

    //ViewModel


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater, container, false)

        //ViewModel
        val movieListViewModel=ViewModelProvider(this).get(MovieListViewModel::class.java)

        //Observing any data change
        fun observeAnyChange(){
            movieListViewModel.getMovies().observe(viewLifecycleOwner, Observer<List<MovieModel>> {
                @Override
                fun onChange(movieModel: List<MovieModel>){



                }


            })
        }

        binding.btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                getRetrofitResponse()
            }
        })
        return binding.root
    }



    fun getRetrofitResponse() {
        val movieApi:MovieApi= Service.getMovieApi()
        val response = movieApi.searchMovie(Credentials.API_KEY, "Action", "1")

       response.enqueue(object : Callback<MovieSearchResponse> {
           override fun onResponse(
                   call: Call<MovieSearchResponse>,
                   response: Response<MovieSearchResponse>
           ) {
               if (response.code() == 200) {
                   Log.d("Tag", "the response " + response.body().toString())
                   if (response.body() != null) {
                       val movies: List<MovieModel> = response.body()!!.getMovies()
                       for (movie in movies){
                           Log.d("Tag","Name "+ movie.title)
                       }
                   }
               } else {
                   try {
                       println(response.code())
                       println(response.raw().request().url())
                       println("**"+response.errorBody()!!.string())
                  }catch (e: JSONException){
                      println("!!!!!!!!!!")
                       e.printStackTrace()
                  }
               }

           }

           override fun onFailure(call: Call<MovieSearchResponse>, t: Throwable) {
               t.printStackTrace()
           }
       })
    }
}
