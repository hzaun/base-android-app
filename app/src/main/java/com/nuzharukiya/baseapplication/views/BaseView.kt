package com.nuzharukiya.baseapplication.views

/**
 * Created by Nuzha Rukiya on 19/10/23.
 */
interface BaseView {

    /**
     * Set the mContext and init UIComponents
     */
    fun initApp()

    /**
     * Find views and set their values
     */
    fun initViews()

    /**
     * Initialize the data
     */
    fun initData()

    /**
     * Start doing the work
     */
    fun runFactory()
}