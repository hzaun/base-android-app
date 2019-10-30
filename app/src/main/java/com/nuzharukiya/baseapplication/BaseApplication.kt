package com.nuzharukiya.baseapplication

import android.app.Application
import com.bumptech.glide.module.AppGlideModule
import com.nuzharukiya.baseapplication.dagger.ApplicationComponent
import com.nuzharukiya.baseapplication.dagger.ContextModule
import com.nuzharukiya.baseapplication.dagger.DaggerApplicationComponent
import retrofit2.Retrofit
import timber.log.Timber

/**
 * Created by Nuzha Rukiya on 19/10/23.
 */

class BaseApplication : Application() {

    var retrofitInstance: Retrofit? = null
        private set
    var appGlideModule: AppGlideModule? = null
        private set

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        val applicationComponent: ApplicationComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()

        retrofitInstance = applicationComponent.getRetrofitInstance()
        appGlideModule = applicationComponent.getAppGlideModule()
    }
}