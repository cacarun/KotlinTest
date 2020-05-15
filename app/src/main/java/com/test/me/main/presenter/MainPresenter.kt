package com.test.me.main.presenter

import com.test.me.util.MODULE_TAG
import com.test.me.main.model.MainModel
import com.test.me.main.view.MainView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainPresenter(scope: CoroutineScope, private val view: MainView): CoroutineScope by scope {

    private val tag = "$MODULE_TAG.MainPresenter"

    private val model = MainModel(view.getIsoCC())

    fun start() {

        launch {

            view.showWaitDialog()

            view.hideUI()

            val dataForUI = model.loadDataForUI()

            if (dataForUI != null) {

                view.initTipsView(dataForUI)

                view.showUI()
            }

            view.dismissWaitDialog()
        }
    }
}