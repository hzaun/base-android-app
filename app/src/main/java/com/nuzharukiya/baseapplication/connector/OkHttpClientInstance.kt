package com.nuzharukiya.baseapplication.connector

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File

/**
 * Created by Nuzha Rukiya on 19/10/23.
 */

class OkHttpClientInstance {
    companion object {
        private var instance: OkHttpClient? = null

        fun getInstance(mContext: Context): OkHttpClient? {
            if (instance == null) {
                instance = createOkHttpClientInstance(mContext)
            }
            return instance
        }

        private fun createOkHttpClientInstance(mContext: Context): OkHttpClient? {
            return OkHttpClient.Builder()
                .addInterceptor(getHttpLoggingInterceptor())
                .cache(getCache(mContext))
                .build()
        }

        private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
            Timber.plant(Timber.DebugTree())
            return HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Timber.i(message)
                }
            })
        }

        private fun getCache(mContext: Context): Cache {
            val cacheFile = File(mContext.cacheDir, "okhttp_cache")
            cacheFile.mkdirs()

            return Cache(cacheFile, 10 * 10 * 1000)
        }
    }
}