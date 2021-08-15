package com.example.moviesapp.fragments

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.data.api.ApiInterface
import com.example.moviesapp.R
import com.example.moviesapp.adapters.MovieAdapter
import com.example.moviesapp.databinding.FragmentMovieOveriewBinding
import com.example.moviesapp.data.datamodels.Movie
import com.example.moviesapp.data.datamodels.results
import com.example.moviesapp.data.viewmodel.MainViewModel
import com.example.moviesapp.utils.helper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 * Use the [MovieOveriewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieOveriewFragment : Fragment() {
    lateinit var binding: FragmentMovieOveriewBinding;
    lateinit var details: results;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            details = requireArguments().get("details") as results;
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* Binding the UI*/
        binding = DataBindingUtil.inflate<FragmentMovieOveriewBinding>(
            inflater,
            R.layout.fragment_movie_overiew, container, false
        );
        binding.progressBar.visibility = View.VISIBLE

        setupRecyclerView()
        if(helper.isOnline(requireContext())){
            initViewModel()
        }else{
            showToast("please check your internet connectivity")
            binding.progressBar.visibility = View.GONE
        }

        binding.rvMovies.setOnClickListener {
            this.findNavController()
                .navigate(R.id.action_movieOveriewFragment_to_movieDetailFragment)
        }

        /*Returning the Root Layout*/
        return binding.root
    }

    private fun initViewModel() {
        val viewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getLiveDataObserver().observe(viewLifecycleOwner,{
            binding.progressBar.visibility = View.GONE
            binding.rvMovies.visibility = View.VISIBLE
            if (it != null ) {
                val adapter =  MovieAdapter(it.results)
                binding.rvMovies.adapter = adapter
            } else {
                showToast("Something Went Wrong")
            }
        })
        viewModel.makeApiCall();
    }




    private fun showToast(toastMessage:String) {
        Toast.makeText(
            requireContext(),
            toastMessage.toString(),
            Toast.LENGTH_SHORT
        ).show()
    }


    private fun setupRecyclerView() {
        /*Setting Up the RecyclerView*/
        val mLayoutManager = LinearLayoutManager(requireContext())
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.rvMovies.layoutManager = mLayoutManager
    }


}