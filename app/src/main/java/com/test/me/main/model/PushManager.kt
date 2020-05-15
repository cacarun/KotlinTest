package com.test.me.main.model

object PushManager {

    interface PushCallback {

        fun onSucceed()

        fun onError()
    }

    fun initPush(flag: Int, callback: PushCallback) {

        Thread(Runnable {

            Thread.sleep(3000)

            if (flag == 1) {

                callback.onSucceed()
            } else {

                callback.onError()
            }

        }).start()
    }
}