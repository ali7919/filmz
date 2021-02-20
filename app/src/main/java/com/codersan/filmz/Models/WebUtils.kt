package com.codersan.filmz

import com.codersan.filmz.Models.Movie
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

private const val BASE_URL = "https://imdb-internet-movie-database-unofficial.p.rapidapi.com/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface MovieApiService {

    //search movie by name
    @Headers("x-rapidapi-key:1314517ef7msh8ebf7ebd6e14860p19b072jsn3d3707c031d1"
        ,"x-rapidapi-host:imdb-internet-movie-database-unofficial.p.rapidapi.com")
    @GET("search/{movieName}")
    suspend fun searchMovie(@Path("movieName")movieName:String): WebList

    //get movie by id
    @Headers("x-rapidapi-key:1314517ef7msh8ebf7ebd6e14860p19b072jsn3d3707c031d1"
        ,"x-rapidapi-host:imdb-internet-movie-database-unofficial.p.rapidapi.com")
    @GET("film/{id}")
    suspend fun getMovie(@Path("id")id:String): Movie

}


object MovieApi {
    val retrofitService : MovieApiService by lazy { retrofit.create(MovieApiService::class.java) }
}


//classes for converting JSON
data class WebList(val titles: List<WebListItem>)
data class WebListItem(val title: String,val id:String,val image:String)

