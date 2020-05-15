package com.test.me

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.test.me.base.ScopedActivity
import com.test.me.main.model.MainForUI
import com.test.me.main.presenter.MainPresenter
import com.test.me.util.MODULE_TAG
import com.test.me.main.view.MainView

class MainActivity : ScopedActivity(), MainView {

    companion object {

        const val tag = "$MODULE_TAG.MainActivity"

        const val INTENT_KEY_isoCC = "isoCC"

        @JvmStatic
        fun start(activity: Activity, isoCC: String) {

            val intent = Intent(activity, MainActivity::class.java)

            intent.putExtra(INTENT_KEY_isoCC, isoCC)

            activity.startActivity(intent)
        }
    }


    private lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(scope = this, view = this)

        presenter.start()
    }

    override fun getIsoCC(): String {
        return intent.getStringExtra(INTENT_KEY_isoCC) ?: ""
    }

    override fun toast(message: String) {
        //
    }

    override fun getContext(): Activity {
        return this
    }

    override fun showWaitDialog() {
        //
    }

    override fun dismissWaitDialog() {
        //
    }

    override fun initUI(data: MainForUI) {
        //
    }

    override fun hideUI() {
        //
    }

    override fun showUI() {
        //
    }

    override fun initTipsView(mainForUI: MainForUI) {
        //
    }

}
