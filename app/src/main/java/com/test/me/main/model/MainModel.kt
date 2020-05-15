package com.test.me.main.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

}


