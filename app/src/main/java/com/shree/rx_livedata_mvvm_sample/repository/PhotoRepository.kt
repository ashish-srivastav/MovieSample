package com.shree.rx_livedata_mvvm_sample.repository

import androidx.lifecycle.MutableLiveData
import com.shree.rx_livedata_mvvm_sample.model.PhotoModel
import com.shree.rx_livedata_mvvm_sample.network.ApiService
import com.shree.rx_livedata_mvvm_sample.provider.RetrofitProvider
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class PhotoRepository {
    private var apiService:ApiService?=null
    val compositeDisposable = CompositeDisposable()
    init {
        apiService = RetrofitProvider.apiService
    }
    val getMutableList:MutableLiveData<MutableList<PhotoModel>>
    get() {
        val data = MutableLiveData<MutableList<PhotoModel>>()
        compositeDisposable.add(apiService?.getPhotos()
            !!.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { photos->
                if(photos!=null){
                    data.value= photos
                }
            }
        )
        return data
    }

}