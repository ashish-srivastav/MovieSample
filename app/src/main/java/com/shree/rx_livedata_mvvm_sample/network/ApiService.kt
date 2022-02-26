package com.shree.rx_livedata_mvvm_sample.network

import com.shree.rx_livedata_mvvm_sample.model.PhotoModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {
    //TODO API key need to put in build.gradle , and update with Query param
    @GET("/now_playing?api_key=38a73d59546aa378980a88b645f487fc&language=en-US&")
    fun getPhotos():Single<MutableList<PhotoModel>>
}