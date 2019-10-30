package com.nuzharukiya.baseapplication.dagger

import dagger.Component
import retrofit2.Retrofit

/**
 * Created by Nuzha Rukiya on 19/10/23.
 */

@Component(modules = [RetrofitModule::class, AppGlideModule::class])
interface ApplicationComponent {

    fun getRetrofitInstance(): Retrofit

    fun getAppGlideModule(): HzAppGlideModule
}