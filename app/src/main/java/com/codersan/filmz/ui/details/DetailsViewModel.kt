package com.codersan.filmz.ui.details

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.codersan.filmz.Models.Movie
import com.codersan.filmz.Models.Repository
import kotlinx.coroutines.launch

class DetailsViewModel(application: Application) : AndroidViewModel(application) {


    private val repository =Repository.getInstace(getApplication())
    lateinit var listener: ValuesReadyListener


    var movie: Movie? = null


    fun getMovie(movieId: String) {
        viewModelScope.launch {
            var options=false //display save button on top or not

            //search in database
            movie = repository.get_movie_local(movieId)

            if (movie == null) {
                //movie doesn't exist in database
                //get movie from web
                movie = repository.get_movie_web(movieId)

                //convert List<CastMember> to String
                var str=""
                for (i in movie!!.cast!!){
                   str+="("+i?.actor+" as "+i?.character+") , "
                }
                movie?.cast_str=str


                options=true
            }

            //data is ready
            listener.OptionMenu(options)
            listener.OnReady()
        }
    }

    //save a movie to database
    fun save(){
        viewModelScope.launch {
            try {
                repository.insert(movie!!)
                Toast.makeText(getApplication(),"Film added",Toast.LENGTH_SHORT).show()
            }catch (e:Exception){
                Toast.makeText(getApplication(),"Film already exist in your archive !",Toast.LENGTH_SHORT).show()

            }


        }
    }


    interface ValuesReadyListener {
        fun OnReady()
        fun OptionMenu(hasMenu:Boolean)
    }


}