package me.ibrahimsn.smoothbottombar.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.ibrahimsn.smoothbottombar.R
import me.ibrahimsn.smoothbottombar.databinding.FragmentFavoritesBinding
import me.ibrahimsn.smoothbottombar.databinding.FragmentHomeBinding
import me.ibrahimsn.smoothbottombar.models.MovieModel
import me.ibrahimsn.smoothbottombar.request.Service
import me.ibrahimsn.smoothbottombar.response.MovieSearchResponse
import me.ibrahimsn.smoothbottombar.utils.Credentials
import me.ibrahimsn.smoothbottombar.utils.MovieApi
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoritesFragment : Fragment() {
    private  var _binding: FragmentFavoritesBinding?=null
    private val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentFavoritesBinding.inflate(inflater, container, false)

        binding.btnFav.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                getRetrofitResponseById()
            }
        })
        return binding.root    }
//https://api.themoviedb.org/3/movie/550?api_key=eb5d3299eff65d8b40d091d81887aba5

    private fun getRetrofitResponseById(){
        val movieApi: MovieApi = Service.getMovieApi()
        val response = movieApi.getMovie(550,Credentials.API_KEY)
        response.enqueue(object : Callback<MovieModel> {
            override fun onResponse(
                call: Call<MovieModel>,
                response: Response<MovieModel>
            ) {
                if(response.code()==200){
                    val movie:MovieModel= response.body()!!
                    println("**** ${movie.title}")
                }else {
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

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}
