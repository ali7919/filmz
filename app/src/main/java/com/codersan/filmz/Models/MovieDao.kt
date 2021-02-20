package com.codersan.filmz.Models

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {


    @Insert
    suspend fun insert(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)

    @Query("DELETE FROM movie_tb")
    suspend fun delete_all()

    @Update
    suspend fun update(movie: Movie)

    @Query("SELECT * FROM movie_tb ORDER BY title DESC")
    fun get_all(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie_tb WHERE id=:id0")
    suspend fun get_movie(id0:String):Movie?

}