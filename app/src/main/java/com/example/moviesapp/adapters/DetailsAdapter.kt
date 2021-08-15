package com.example.moviesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.databinding.DetailsViewBinding
import com.example.moviesapp.data.datamodels.info

class DetailsAdapter(private val details: ArrayList<info>) : RecyclerView.Adapter<DetailsAdapter.MyViewHolder>() {
    lateinit private var binding: DetailsViewBinding;
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.tv_title);
        val value = itemView.findViewById<TextView>(R.id.value);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate<DetailsViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.details_view, parent, false
        )

        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item=details.get(position)
        holder.title.text=item.title+" : "
        holder.value.text=item.value
    }

    override fun getItemCount(): Int {
        return details.size
    }
}