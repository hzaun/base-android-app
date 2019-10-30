package com.nuzharukiya.baseapplication.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File

/**
 * Created by Nuzha Rukiya on 19/10/23.
 */

@Module(includes = [ContextModule::class])
class NetworkModule {

    @Provides
    @ApplicationScope
    fun getOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .cache(cache)
            .build()
    }

    @Provides
    @ApplicationScope
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val hli = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.i(message)
            }
        })
        hli.level = HttpLoggingInterceptor.Level.BASIC
        return hli
    }

    @Provides
    @ApplicationScope
    fun getCache(cacheFile: File): Cache {
        return Cache(cacheFile, 10 * 10 * 1000)
    }

    @Provides
    @ApplicationScope
    fun getFile(mContext: Context): File {
        val cacheFile = File(mContext.cacheDir, "okhttp_cache")
        cacheFile.mkdirs()

        return cacheFile
    }
}