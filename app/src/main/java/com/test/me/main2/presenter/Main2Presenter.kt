package com.test.me.main2.presenter

import com.test.me.main2.model.Main2Model
import com.test.me.main2.view.Main2View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

class Main2Presenter(private val main2View: Main2View): CoroutineScope by MainScope() {

    private val model = Main2Model()

    fun start() {

        main2View.initView(this)

        main2View.hideView()

        model.loadData()

        main2View.showView()
    }

    fun loadDataAndJumpToPage() {

    }

    fun destroy() {
        cancel()
    }
}