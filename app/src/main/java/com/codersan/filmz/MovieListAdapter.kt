package com.codersan.filmz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codersan.filmz.Models.Movie
import com.codersan.filmz.databinding.EachMovieBinding

class MovieListAdapter : ListAdapter<Movie, MovieListAdapter.VH>(

    //dif utils for ListAdapter
    object : DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id==newItem.id
        }
        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id==newItem.id && oldItem.plot==newItem.plot
        }}) {

    lateinit var listener: OpenDetailsListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(EachMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position,getItem(position))
    }

    //get movie at position from outside
    fun get_movie_at(adapterPosition: Int): Movie {
        return getItem(adapterPosition)
    }

    inner class VH(var binding:EachMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, item: Movie){
            //init binding values
            binding.apply {
                name=item.title
                url=item.poster
                root.setOnClickListener { listener.go_to_details(item.id) } //onclick listener for each movie
            }
        }
    }

    fun interface OpenDetailsListener{
        fun go_to_details(id:String)
    }

}