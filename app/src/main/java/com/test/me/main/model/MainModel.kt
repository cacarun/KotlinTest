package com.test.me.main.model

import android.util.Log
import com.test.me.R
import com.test.me.util.asIdToString
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MainModel(private val isoCC: String) {

    private var mainFromServer: MainFromServer? = null

    suspend fun loadDataForUI(): MainForUI? {

        return withContext(Dispatchers.Default) {

            mainFromServer?.convertToMainForUI()
        }
    }

    private fun MainFromServer.convertToMainForUI(): MainForUI {

        Log.d("", "server data size=${itemData.size}")

        return MainForUI(itemData = MainForUI.ItemData(
                R.string.title.asIdToString(),
                R.string.desc.asIdToString()))
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


