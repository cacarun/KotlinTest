package com.test.me.main.view

import com.test.me.base.BaseView
import com.test.me.main.model.MainForUI

interface MainView : BaseView<MainForUI> {

    fun initTipsView(mainForUI: MainForUI)

    fun getIsoCC(): String

    fun toast(message: String)
}
