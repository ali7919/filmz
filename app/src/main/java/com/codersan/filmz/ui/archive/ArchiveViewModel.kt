package com.codersan.filmz.ui.archive

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.codersan.filmz.Models.Movie
import com.codersan.filmz.Models.Repository
import com.codersan.filmz.MovieListAdapter
import kotlinx.coroutines.launch

class ArchiveViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository.getInstace(application)
    var all: LiveData<List<Movie>> = repository.dao.get_all()
    val adapter = MovieListAdapter()

    //touchhelper for swiping
    val touchhelper= ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.DOWN or ItemTouchHelper.UP,
        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
    ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            delete(adapter.get_movie_at(viewHolder.adapterPosition))
            Toast.makeText(application.applicationContext, "deleted", Toast.LENGTH_SHORT).show()
        }
    })




    //delete all
    fun delete_all() {
        viewModelScope.launch {
            repository.delete_all()
        }
    }


    //swipe to delete one
    fun delete(movie: Movie){
        viewModelScope.launch {
            repository.delete(movie)
        }
    }


}