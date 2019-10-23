package com.nuzharukiya.baseapplication.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.nuzharukiya.baseapplication.presenters.BasePresenter
import com.nuzharukiya.baseapplication.views.BaseView
import okhttp3.logging.HttpLoggingInterceptor

class BaseActivity : AppCompatActivity(), BaseView {

    private lateinit var mContext: Context
    private lateinit var mPresenter: BasePresenter

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)

        initApp()
        initViews()
        initData()
        runFactory()
    }

    override fun initApp() {
        mContext = this

        mPresenter = BasePresenter(this)
    }

    override fun initViews() {
    }

    override fun initData() {
    }

    override fun runFactory() {
    }
}
