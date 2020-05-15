package com.test.me.test

import kotlin.random.Random


data class ScopePerson(var name: String, var age: Int = 0, var city: String = ""){
    fun moveTo(newCity: String) { city = newCity }
    fun incrementAge() { age++ }
}


/**
 * 作用域函数 apply/with/run/also/let
 *
 * 1，判断上下文对象：this 还是 it
 *
 * this: run, with, apply
 *
 * it: also, let  （用作参数被其他函数调用）
 *
 *
 * 2，返回值
 *
 * 上下文对象: apply, also
 *
 * Lambda 表达式结果: let, run, with  （链式操作上一个闭包返回的结果，此外你可以忽略返回值，使用 with 作用域函数来为变量创建一个临时作用域）
 *
 *
 */
fun main() {


    val adam = ScopePerson("Adam").apply {
        age = 20                       // same as this.age = 20 or adam.age = 20
        city = "London"
    }

    val str = "Hello"
    str.run {
        println("The receiver string length: $length")
        //println("The receiver string length: ${this.length}") // does the same
    }

    val numbers = mutableListOf("one", "two", "three")
    val countEndsWithE = numbers.run {
        add("four")
        add("five")
        count { it.endsWith("e") }
    }
    println("There are $countEndsWithE elements that end with e.")


    with(numbers) {
        val firstItem = first()
        val lastItem = last()
        println("First item: $firstItem, last item: $lastItem")
    }


    val memberList = mutableListOf<Int>()
    memberList.also {
        println("填充 $it")
    }.apply {
        add(35)
        add(98)
        add(1)
        add(18)
    }.also {
        println("排序并打印 $it")
    }.also {
        it.sort()
        println(it)
    }



    ScopePerson("Alice", 20, "Amsterdam").let {
        println(it)
        it.moveTo("London")
        it.incrementAge()
        println(it)
    }

    str.let {
        println("The receiver string's length is ${it.length}")
    }

    fun getRandomInt(): Int {
        return Random.nextInt(100).also {
            println("getRandomInt() generated value $it")
        }
    }
    println(getRandomInt())



}





