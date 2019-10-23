package com.nuzharukiya.baseapplication.connector

import okhttp3.OkHttpClient

/**
 * Created by Nuzha Rukiya on 19/10/23.
 */

class OkHttpClientInstance {
    companion object {
        var instance: OkHttpClient? = null
            get() {
                if (field == null) {
                    field = OkHttpClient()
                }
                return field
            }
    }
}