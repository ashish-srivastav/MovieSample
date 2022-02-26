package com.shree.rx_livedata_mvvm_sample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shree.rx_livedata_mvvm_sample.model.PhotoModel
import com.shree.rx_livedata_mvvm_sample.repository.PhotoRepository

class MainActivityViewModel:ViewModel() {
private val photoRepo:PhotoRepository
init {
    photoRepo= PhotoRepository()
}
    val getMovieList:LiveData<MutableList<PhotoModel>>
    get() = photoRepo.getMutableList
}