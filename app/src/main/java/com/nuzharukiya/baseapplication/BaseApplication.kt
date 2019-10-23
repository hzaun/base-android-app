package com.nuzharukiya.baseapplication

import android.app.Application
import android.content.Context
import com.bumptech.glide.module.AppGlideModule
import com.nuzharukiya.baseapplication.connector.OkHttpClientInstance
import com.nuzharukiya.baseapplication.connector.RetrofitClientInstance
import com.nuzharukiya.baseapplication.utils.HzGlideModule
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * Created by Nuzha Rukiya on 19/10/23.
 */

class BaseApplication : Application() {

    lateinit var mContext: Context

    var retrofitInstance: Retrofit? = null
        private set
    var okHttpClientInstance: OkHttpClient? = null
        private set
    var appGlideModule: AppGlideModule? = null
        private set

    override fun onCreate() {
        super.onCreate()

        mContext = this

        retrofitInstance = RetrofitClientInstance.instance
        okHttpClientInstance = OkHttpClientInstance.getInstance(mContext)

        appGlideModule = okHttpClientInstance?.let { HzGlideModule(it) }
    }
}