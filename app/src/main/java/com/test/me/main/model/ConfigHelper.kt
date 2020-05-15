package com.test.me.main.model

import android.content.Context
import com.test.me.App

object ConfigHelper {

    private const val SP_FILE_NAME = "com.test.me.main.model.ConfigHelper"

    private val sp = App.instance().getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)

    private const val KEY_STATUS = "status"

    var status: Int
        set(value) = sp.edit().putInt(KEY_STATUS, value).apply()
        get() = sp.getInt(KEY_STATUS, 0)
}