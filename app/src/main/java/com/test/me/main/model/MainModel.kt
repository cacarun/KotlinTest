package com.test.me.main.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MainModel(private val isoCC: String) {

    private var mainFromServer: MainFromServer? = null

    suspend fun loadDataForUI(): MainForUI? {

        return withContext(Dispatchers.Default) {

            mainFromServer?.let { _ ->

                val mainForUI = MainForUI(itemData = MainForUI.ItemData("title", "desc"))

                return@let mainForUI
            }
        }
    }

    private fun isUS(): Boolean {

        return isoCC == "US"
    }

    suspend fun initPush(flag: Int) = suspendCoroutine<String> {

        PushManager.initPush(flag, object : PushManager.PushCallback {

            override fun onSucceed() {

                it.resume("Success!")
            }

            override fun onError() {

//                it.resumeWithException(RuntimeException("Error!"))
                it.resume("Error!")
            }

        })
    }

}


