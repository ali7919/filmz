package com.codersan.filmz.ui.search

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import com.codersan.filmz.Models.Repository
import com.codersan.filmz.MovieListAdapter
import com.codersan.filmz.WebListItem
import com.ferfalk.simplesearchview.SimpleSearchView
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {



    var searching:MutableLiveData<Int> = MutableLiveData(View.INVISIBLE)
    var messageVisibility:MutableLiveData<Int> = MutableLiveData(View.VISIBLE)
    private val repository = Repository.getInstace(getApplication())
    val adapter = MovieListAdapter()
    var all: MutableLiveData<List<WebListItem>> = MutableLiveData()

    //search view text listener
    val searchListener=object : SimpleSearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {
            messageVisibility.value=View.GONE
            search(query)
            return false
        }

        override fun onQueryTextChange(newText: String)=false
        override fun onQueryTextCleared()=false
    }




    //search by movie name
    fun search(name:String) {
        searching.value=View.VISIBLE //visibility of the progressbar

        viewModelScope.launch {

            try {

                //get List<WebListItem> from web
                all.value=repository.search_movie(name)
                searching.value=View.INVISIBLE


            }catch (e:Exception){
                Toast.makeText(getApplication(),"connection error!", Toast.LENGTH_SHORT).show()


            }

        }
    }






}