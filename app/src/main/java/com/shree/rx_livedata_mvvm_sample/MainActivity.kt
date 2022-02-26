package com.shree.rx_livedata_mvvm_sample
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shree.rx_livedata_mvvm_sample.adapter.MovieListAdapter
import com.shree.rx_livedata_mvvm_sample.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    var viewModel:MainActivityViewModel? = null
    var recycler_view:RecyclerView?=null
    var adapter:MovieListAdapter?=null
    var layoutManager:RecyclerView.LayoutManager?=null
   var dialog : AlertDialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProvider(this)[MainActivityViewModel::class.java]
     //   var dialog= SpotsDialo
        recycler_view = findViewById(R.id.reycler_lst)
        layoutManager= LinearLayoutManager(this)
        recycler_view!!.layoutManager= layoutManager
        viewModel!!.getMovieList.observe(this,{postmodel->
            Log.e("MainActivity","MovieList"+postmodel)
            adapter= MovieListAdapter(this,postmodel)
            adapter!!.notifyDataSetChanged()
            recycler_view!!.adapter= adapter
        })
    }
}