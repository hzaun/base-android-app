package com.nuzharukiya.baseapplication

import android.app.Application
import com.bumptech.glide.Glide
import com.nuzharukiya.baseapplication.connector.OkHttpClientInstance
import com.nuzharukiya.baseapplication.connector.RetrofitClientInstance
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * Created by Nuzha Rukiya on 19/10/23.
 */

class BaseApplication : Application() {

    private var retrofitInstance: Retrofit? = null
    private var okHttpClientInstance: OkHttpClient? = null
    private var glide: Glide? = null

    override fun onCreate() {
        super.onCreate()

        retrofitInstance = RetrofitClientInstance.instance
        okHttpClientInstance = OkHttpClientInstance.instance
    }
}