package com.shree.rx_livedata_mvvm_sample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shree.rx_livedata_mvvm_sample.R
import com.shree.rx_livedata_mvvm_sample.adapter.MovieListAdapter.*
import com.shree.rx_livedata_mvvm_sample.model.PhotoModel

class MovieListAdapter(var context:Context,var movieList:MutableList<PhotoModel>):
RecyclerView.Adapter<MyViewHolder>(){

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var movieName: TextView
        var movieRating: TextView
        var playlist: TextView
        var movieWallPic: ImageView
        init {
            movieName= itemView.findViewById(R.id.movie_name)
            movieWallPic = itemView.findViewById(R.id.wall_pic)
            movieName= itemView.findViewById(R.id.movie_name)
            movieRating= itemView.findViewById(R.id.rating)
            playlist= itemView.findViewById(R.id.playlist_name)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_movie_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.movieName.text=movieList[position].title
    //Image loading with Glide
    //holder.movieWallPic = movieList[position].thumbnailUrl
    }

    override fun getItemCount(): Int {
       return movieList.size
    }
}