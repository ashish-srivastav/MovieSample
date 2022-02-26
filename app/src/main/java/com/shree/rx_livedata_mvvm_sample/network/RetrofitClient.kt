package com.shree.rx_livedata_mvvm_sample.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private var retrofit:Retrofit? = null

    fun getRetrofitClient(baseUrl:String):Retrofit{
        val interceptor   = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okhttpClient= OkHttpClient().newBuilder()
            .readTimeout((60*2).toLong(),TimeUnit.SECONDS)
            .writeTimeout((60*2).toLong(),TimeUnit.SECONDS)
            .connectTimeout((60*2).toLong(),TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
        if(retrofit==null){
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        }
        return retrofit!!

    }





}