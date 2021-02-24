package com.codersan.filmz.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.codersan.filmz.MainActivity
import com.codersan.filmz.R
import com.codersan.filmz.databinding.DetailsFragmentBinding

class DetailsFragment : Fragment() {



    private lateinit var vm: DetailsViewModel
    private lateinit var binding: DetailsFragmentBinding

    //args from previous fragment (contains the movie id)
    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding= DetailsFragmentBinding.inflate(inflater,container,false)
        vm = ViewModelProvider(this).get(DetailsViewModel::class.java)
        binding.vm=vm

        (activity as MainActivity).supportActionBar?.title="Loading..."


        vm.listener= DetailsViewModel.ValuesReadyListener { hasMenu ->
            //data is ready

            //set menu
            setHasOptionsMenu(hasMenu)

            binding.invalidateAll()
            binding.pb.visibility=View.GONE

            //change actionbar title
            (activity as MainActivity).supportActionBar?.title=vm.movie?.title
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //get movie either from web or local
        vm.getMovie(args.movieId)



    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.savemenu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //add to database
            R.id.save -> vm.save()
        }
        return super.onOptionsItemSelected(item)
    }


}