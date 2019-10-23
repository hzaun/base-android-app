package com.nuzharukiya.baseapplication.connector

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nuzharukiya.baseapplication.utils.URLS
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Nuzha Rukiya on 18/09/23.
 */

class RetrofitClientInstance {
    companion object {
        var instance: Retrofit? = null
            get() {
                if (field == null) {
                    field = createRetrofitInstance()
                }
                return field
            }

        private fun buildGson(): Gson {
            return GsonBuilder()
                .setLenient()
                .create()
        }

        private fun createRetrofitInstance(): Retrofit {
            val retrofitBuilder = Retrofit.Builder()
                .baseUrl(URLS.BASE)
                .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

            OkHttpClientInstance.instance?.let {
                retrofitBuilder.client(it)
            }

            return retrofitBuilder.build()
        }
    }
}