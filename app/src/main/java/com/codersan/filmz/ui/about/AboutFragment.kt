package com.codersan.filmz.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.codersan.filmz.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {

    private lateinit var vm: AboutViewModel
    private lateinit var binding: FragmentAboutBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentAboutBinding.inflate(inflater,container,false)
        vm = ViewModelProvider(this).get(AboutViewModel::class.java)
        binding.vm=vm
        return binding.root
    }


}