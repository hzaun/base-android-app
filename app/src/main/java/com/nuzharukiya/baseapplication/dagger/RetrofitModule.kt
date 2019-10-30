package com.nuzharukiya.baseapplication.dagger

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nuzharukiya.baseapplication.utils.URLS
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Nuzha Rukiya on 19/10/23.
 */

@Module(includes = [NetworkModule::class])
class RetrofitModule {

    @Provides
    fun getRetrofitClientInstance(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(URLS.BASE)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        return retrofitBuilder.build()
    }

    @Provides
    fun getGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }
}