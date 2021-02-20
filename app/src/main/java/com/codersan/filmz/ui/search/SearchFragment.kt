package com.codersan.filmz.ui.search

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.codersan.filmz.MainActivity
import com.codersan.filmz.Models.Movie
import com.codersan.filmz.MovieListAdapter
import com.codersan.filmz.R
import com.codersan.filmz.databinding.FragmentSearchBinding
import com.ferfalk.simplesearchview.SimpleSearchView

class SearchFragment : Fragment() {

    private lateinit var vm: SearchViewModel
    private lateinit var binding: FragmentSearchBinding
    lateinit var searchView: SimpleSearchView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        vm = ViewModelProvider(this).get(SearchViewModel::class.java)
        binding = FragmentSearchBinding.inflate(inflater, container, false)


        //inti recycler view
        binding.listviewsearch.layoutManager = GridLayoutManager(binding.root.context,2)
        binding.listviewsearch.adapter = vm.adapter

        binding.vm=vm
        binding.lifecycleOwner=this //lifecycle owner for live data changes

        setHasOptionsMenu(true) //change menu

        searchView=(activity as MainActivity).searchView

        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //onclick listener for each movie
        vm.adapter.listener=object : MovieListAdapter.OpenDetailsListener{
            override fun go_to_details(id: String) {
                val action = SearchFragmentDirections.actionNavigationNotificationsToDetailsFragment(
                    id
                )
                findNavController().navigate(action)
            }
        }

        //update recycler view
        vm.all.observe(viewLifecycleOwner, {

            if (it.isEmpty())Toast.makeText(activity,"found nothing !",Toast.LENGTH_SHORT).show()

            //convert WebListItem to Movie
            val searchedList: MutableList<Movie> = mutableListOf()
            for (i in it)
                searchedList.add(Movie(i.id, i.title, "", "", "", "", "", i.image, ""))

            //update recycler view
            vm.adapter.submitList(searchedList)


        })


        //init search view
        searchView.setOnQueryTextListener(vm.searchListener)







    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        //search view
        inflater.inflate(R.menu.searchmenu, menu)
        val item=menu.findItem(R.id.action_search)
        searchView.setMenuItem(item)

    }

    override fun onPause() {
        super.onPause()
        searchView.closeSearch(true)
    }


}