package com.example.moviesapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.adapters.DetailsAdapter
import com.example.moviesapp.databinding.FragmentMovieDetailBinding
import com.example.moviesapp.data.datamodels.info
import com.example.moviesapp.data.datamodels.results

/**
 * A simple [Fragment] subclass.
 * Use the [MovieDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieDetailFragment : Fragment() {
    lateinit var binding: FragmentMovieDetailBinding;

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
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentMovieDetailBinding>(
            inflater,
            R.layout.fragment_movie_detail, container, false
        );
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        /*Setting Up the RecyclerView*/
        val mLayoutManager = LinearLayoutManager(requireContext())
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.rvDetails.layoutManager = mLayoutManager

        val resources = resources.getStringArray(R.array.movieMetaDataKey)

        val movieDetails = arrayListOf<info>();

        resources.forEach { str: String ->
            val data = str.split(":")
            val value:String? = getValue(data[1]);
            val inf = value?.let { info(data[0], it) }
            inf?.let { movieDetails.add(it) }
        }

        val adapter = DetailsAdapter(movieDetails)
        binding.rvDetails.adapter = adapter

    }

    private fun getValue(value: String): String {
        return when (value) {
            "display_title" -> details.display_title
            "mpaa_rating" -> details.mpaa_rating
            "byline" -> details.byline
            "headline" -> details.headline
            "summary_short" -> details.summary_short
            "publication_date" -> details.publication_date
            "opening_date" -> details.opening_date
            "type" -> details.link.type
            "suggested_link_text" -> details.link.suggested_link_text
            "url" -> details.link.url
            else -> "-NA-"

        }
    }


}