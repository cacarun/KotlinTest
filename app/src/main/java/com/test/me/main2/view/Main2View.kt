package com.test.me.main2.view

import android.content.Context
import android.view.View
import com.test.me.main2.presenter.Main2Presenter
import kotlinx.android.synthetic.main.activity_main2.view.*

class Main2View(private val rootView: View) {

    val context: Context = rootView.context

    fun initView(main2Presenter: Main2Presenter) {

        rootView.btn1.setOnClickListener {

            main2Presenter.loadDataAndJumpToPage()
        }

        rootView.btn2.setOnClickListener {

        }

    }

    fun hideView() {

    }

    fun showView() {

    }
}