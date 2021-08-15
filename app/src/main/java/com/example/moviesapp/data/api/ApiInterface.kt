package com.example.moviesapp.data.api

import com.example.moviesapp.data.datamodels.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    val API_KEY: String
        get() = "FUWosYmUg5lyyve6za3sIc9Wa74FXEU3"

    @GET("svc/movies/v2/reviews/search.json?query=thor&api-key=FUWosYmUg5lyyve6za3sIc9Wa74FXEU3")
    fun GetMovies(): Call<Movie>;

    companion object {
        //        https://api.nytimes.com/svc/movies/v
        //        2/reviews/search.json?query=godfather&api-key
        //        =FUWosYmUg5lyyve6za3sIc9Wa74FXEU3
        var BASE_URL = "https://api.nytimes.com/"
        fun create(): ApiInterface {
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build().create(ApiInterface::class.java)
        }

    }
}