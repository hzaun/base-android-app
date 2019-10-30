package com.nuzharukiya.baseapplication.dagger

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.io.InputStream

/**
 * Created by Nuzha Rukiya on 19/10/23.
 */

@Module(includes = [NetworkModule::class])
class AppGlideModule {

    @Provides
    fun getAppGlideModule(urlLoaderFactory: OkHttpUrlLoader.Factory): HzAppGlideModule {
        return HzGlideModule(urlLoaderFactory)
    }

    @Provides
    fun getOkHttpUrlLoaderFactory(client: OkHttpClient): OkHttpUrlLoader.Factory {
        return OkHttpUrlLoader.Factory(client)
    }
}

@GlideModule
class HzGlideModule(private val urlLoaderFactory: OkHttpUrlLoader.Factory) : HzAppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        glide.registry.replace(GlideUrl::class.java, InputStream::class.java, urlLoaderFactory)
    }
}

@GlideModule
open class HzAppGlideModule : AppGlideModule()