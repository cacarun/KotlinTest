package com.test.me.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.test.me.R

const val topValue = "Top Value"

class TestActivity : AppCompatActivity() {


    val a: Int = 1  // 立即赋值
    val b = 2   // 自动推断出 `Int` 类型
//    val c: Int


    val s1 = "a is $topValue"
    val s2 = "${s1.replace("Top", "Inner")}, good"



    fun maxOf(a: Int, b: Int) = if (a > b) a else b


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


    }
}
