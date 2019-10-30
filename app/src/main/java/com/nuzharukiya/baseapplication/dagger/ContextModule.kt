package com.nuzharukiya.baseapplication.dagger

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Nuzha Rukiya on 19/10/23.
 */

@Module
class ContextModule(private val mContext: Context) {

    @Provides
    @ApplicationScope
    fun getContext(): Context {
        return mContext
    }
}