package com.test.me.base

import android.app.Activity

interface BaseView<T> {

    fun getContext(): Activity

    fun showWaitDialog()
    fun dismissWaitDialog()

    fun initUI(data: T)

    fun hideUI()
    fun showUI()
}