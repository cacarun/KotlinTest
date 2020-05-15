package com.test.me.util

import com.test.me.App

internal fun Int.asIdToString(): String {

    return App.instance().getString(this)
}