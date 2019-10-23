package com.nuzharukiya.baseapplication.utils

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import okhttp3.OkHttpClient
import java.io.InputStream


/**
 * Created by Nuzha Rukiya on 19/10/23.
 */
@GlideModule
class HzGlideModule(private val client: OkHttpClient) : HzAppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        val factory = OkHttpUrlLoader.Factory(client)

        glide.registry.replace(GlideUrl::class.java, InputStream::class.java, factory)
    }
}

@GlideModule
open class HzAppGlideModule : AppGlideModule()