package com.shree.rx_livedata_mvvm_sample.provider

import com.shree.rx_livedata_mvvm_sample.network.ApiService
import com.shree.rx_livedata_mvvm_sample.network.RetrofitClient

object RetrofitProvider {
    private const val BASE_URL = " https://api.themoviedb.org/3/movie"
    val apiService:ApiService
    get() = RetrofitClient.getRetrofitClient(BASE_URL).create(ApiService::class.java)
}