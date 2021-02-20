package com.codersan.filmz.ui.archive

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.codersan.filmz.MovieListAdapter
import com.codersan.filmz.R
import com.codersan.filmz.databinding.FragmentArchiveBinding

class ArchiveFragment : Fragment() {

    private lateinit var vm: ArchiveViewModel
    private lateinit var binding: FragmentArchiveBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        vm = ViewModelProvider(this).get(ArchiveViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_archive, container, false)
        setHasOptionsMenu(true)


        //init recycler view
        binding.listview.layoutManager = GridLayoutManager(binding.root.context,2)
        binding.listview.adapter = vm.adapter


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //onclick listener interface for each movie
        vm.adapter.listener=object : MovieListAdapter.OpenDetailsListener{
            override fun go_to_details(id: String) {
                val action = ArchiveFragmentDirections.actionNavigationDashboardToDetailsFragment(id)
                findNavController().navigate(action)
            }
        }

        //observe data for changes(deletes)
        vm.all.observe(viewLifecycleOwner, {
            vm.adapter.submitList(it)
            if (it.isEmpty())binding.emptyMessage.visibility=View.VISIBLE
        })


        //swipe to delete
        vm.touchhelper.attachToRecyclerView(binding.listview)


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.top_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            //delete all
            R.id.delete_menu -> vm.delete_all()

            //go to aboutus
            R.id.aboutus -> findNavController().navigate(R.id.action_navigation_archive_to_aboutFragment)
        }
        return super.onOptionsItemSelected(item)
    }

}
