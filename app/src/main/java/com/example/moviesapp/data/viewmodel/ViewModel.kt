package com.example.moviesapp.data.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.data.api.ApiInterface
import com.example.moviesapp.data.datamodels.Movie
import retrofit2.Call
import retrofit2.Response

class MainViewModel: ViewModel(){

    var movieList : MutableLiveData<Movie>

    init {
        movieList= MutableLiveData()
    }

    fun getLiveDataObserver():MutableLiveData<Movie>{
        return  movieList
    }

    fun makeApiCall(){
        val  call = ApiInterface.create().GetMovies()
        call.enqueue(object : retrofit2.Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                Log.i("Movies", response.toString());
                if (response.code() == 200) {
                    movieList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                movieList.postValue(null)
            }

        })

    }

}


