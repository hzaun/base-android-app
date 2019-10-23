package com.nuzharukiya.baseapplication.connector

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

/**
 * Created by Nuzha Rukiya on 19/10/23.
 */

class OkHttpClientInstance {
    companion object {
        var instance: OkHttpClient? = null
            get() {
                if (field == null) {
                    field = createOkHttpClientInstance()
                }
                return field
            }

        private fun createOkHttpClientInstance(): OkHttpClient? {
            return OkHttpClient.Builder()
                .addInterceptor(getHttpLoggingInterceptor())
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
    }
}