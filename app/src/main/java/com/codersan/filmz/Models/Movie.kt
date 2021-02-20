package com.codersan.filmz.Models

import androidx.room.*


data class CastMember(val actor: String, val character: String)


@Entity(tableName = "movie_tb")
data class Movie @Ignore constructor(
    @PrimaryKey val id: String,
    val title: String,
    val year: String,
    val length: String,
    val rating: String,
    val rating_votes: String,
    val plot: String,
    val poster: String,
    var cast_str:String?,
    @Ignore val cast: List<CastMember?>?
) {


    //constructor for room
    constructor(
        id: String,
        title: String,
        year: String,
        length: String,
        rating: String,
        rating_votes: String,
        plot: String,
        poster: String,
        cast_str: String?
    ) : this(
        id,
        title,
        year,
        length,
        rating,
        rating_votes,
        plot,
        poster,
        cast_str,
        null
    )



}


