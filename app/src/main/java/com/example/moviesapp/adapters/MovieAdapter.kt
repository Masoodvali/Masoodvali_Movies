package com.example.moviesapp.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.databinding.MoviesItemBinding
import com.example.moviesapp.data.datamodels.results

class MovieAdapter(private val moviesList: List<results>) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    lateinit private var binding: MoviesItemBinding
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mvImage:ImageView = itemView.findViewById(R.id.movie_image)
        val mvName:TextView = itemView.findViewById(R.id.movie_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         binding = DataBindingUtil.inflate<MoviesItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.movies_item, parent, false
        )

        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = moviesList.get(position)
        binding.movieName.setOnClickListener { view: View ->
            val bundle = Bundle()
            bundle.putSerializable("details",moviesList.get(getItemViewType(position)))
            view.findNavController()
                .navigate(R.id.action_movieOveriewFragment_to_movieDetailFragment,bundle)
        }
        binding.movieImage.setOnClickListener { view: View ->
            val bundle = Bundle()
            bundle.putSerializable("details",moviesList.get(getItemViewType(position)))
            view.findNavController()
                .navigate(R.id.action_movieOveriewFragment_to_movieDetailFragment,bundle)
        }
        holder.mvName.text = item.display_title
        holder.mvImage?.setImageResource(R.drawable.ic_launcher_background)
        Glide.with(holder.mvImage).load(item.multimedia?.src)
            .error(R.drawable.ic_launcher_background).into(holder.mvImage)

    }
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}