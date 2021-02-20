package com.codersan.filmz.Models

import android.app.Application
import androidx.lifecycle.LiveData
import com.codersan.filmz.MovieApi
import com.codersan.filmz.WebListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(var dao: MovieDao, var all: LiveData<List<Movie>>?) {

    private constructor (application: Application) : this(
        DataBase.get_instace(application).dao(),
        null
    ) {
        all = dao.get_all()
    }


    //singleton
    companion object {
        private var instance: Repository? = null
        fun getInstace(application: Application): Repository {
            return instance ?: Repository(application)
        }
    }

    //room functions
    suspend fun get_movie_local(id:String) : Movie? {
        return dao.get_movie(id)
    }

    suspend fun insert(movie: Movie) {
        dao.insert(movie)
    }

    suspend fun delete(movie: Movie) {
        dao.delete(movie)
    }

    suspend fun update(movie: Movie) {
        dao.update(movie)
    }

    suspend fun delete_all() {
        dao.delete_all()
    }

    //retrofit functions
    suspend fun search_movie(name:String):List<WebListItem> = withContext(Dispatchers.Default){

        return@withContext MovieApi.retrofitService.searchMovie(name).titles

    }

    suspend fun get_movie_web(id:String):Movie = withContext(Dispatchers.Default){

        return@withContext MovieApi.retrofitService.getMovie(id)

    }

}