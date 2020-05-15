package com.test.me.base

import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

abstract class ScopedActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    override fun onDestroy() {
        cancel()
        super.onDestroy()
    }
}