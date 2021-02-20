package com.codersan.filmz.ui


import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.codersan.filmz.Models.Movie

import com.bumptech.glide.request.RequestOptions
import com.codersan.filmz.R

//set Movie Image in details fragment
@BindingAdapter("setImageMovie")
fun setImg(view: ImageView, movie: Movie?) {
    if (movie != null) {
        val url = movie.poster
        val imgUri = url.toUri().buildUpon().scheme("https").build()
        Glide.with(view.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(view)
    }
}


//set Movie Image in RecyclerView
@BindingAdapter("setImageMovieReady")
fun setImg(view: ImageView, url: String) {
    val imgUri = url.toUri().buildUpon().scheme("https").build()
    Glide.with(view.context)
        .load(imgUri)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
        )
        .into(view)
}