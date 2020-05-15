package com.test.me.test

import android.os.Build
import android.support.annotation.RequiresApi

class TestMain {

}


// DTOs（POJOs/POCOs）
data class TestMyData(val name: String = "", val email: String = "")


// 单例
object TestMyObject {
    const val name = "cjw"
}


fun main() {

//    val testData = TestMyData("jarvis", "jarvis@gmail.com")
//
//    println("hello world ${testData.name}, ${TestMyObject.name}")
//
//    val files = File("Test").listFiles()
//
//    // If not null 缩写
//    // 如果是 null，默认输出 null
//    println(files?.size)
//
//    // If not null and else 缩写
//    // 如果是 null，自定义输出 empty
//    println(files?.size ?: "empty")
//
//    // if null 执行一个语句
//    val values = mapOf("one" to 1, "two" to 2, "three" to 3)
//    println(values["one"] ?: throw IllegalStateException("Four is missing!"))
//
//    val list = mutableListOf(null, 22, 33)
//    println(list.firstOrNull() ?: "first is null")
//
//    // if not null
//    val value = list.first()
//    value?.let { println("value not null") }
//
//    // 映射可空值（如果非空的话）
//    println(value?.let { it -> it + 1 } ?: 44)
//
//
//
//    println(whenUsage("Blue"))
//
//    tryUsage()
//
//    arrayOfMinusOnes(2).forEach { println(it) }
//
//    withUsage()
//
//
//    val a = """if(a > 1) {
//          |    return a
//          |}""".trimMargin()
//    println(a)
//
//
//    println(decimalDigitValue('1'))

    returnUsage()


}


fun arrayUsage() {
    val arrayEmpty = emptyArray<String>()

    val array1 = arrayOf(3)
    for (i in 0..2) {
        array1[i] = i
    }

    val array2 = arrayOf("a", "b", "c")
    val array3 = intArrayOf(1, 2, 3)

    val array4 = Array(5) {0}
    val array5 : Array<String> = Array(5) {""}
    array5.forEach {
        println(it)
    }
}

@RequiresApi(Build.VERSION_CODES.N)
fun mapUsage() {
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")

    println(map.getOrDefault(20, "NONE"))
    println(map.filter { it.key % 2 != 0 })
    map.forEach { (k, v) -> println("$k -> $v") }
}

fun whenUsage(color: String): Int = when (color) {
    "Red" -> 0
    "Green" -> 1
    "Blue" -> 2
    else -> throw IllegalArgumentException("Invalid color param value")
}

fun ifUsage(param: Int): String {
//    return if (param == 1) {
//        "one"
//    } else if (param == 2) {
//        "two"
//    } else {
//        "three"
//    }

    return if (param == 1) "one" else "other"

    // 如果需要在条件语句中用到可空的 Boolean, 使用 if (value == true) 或 if (value == false) 检测。
}

fun tryUsage() {
    val result = try {
        "try..."
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }

    // 使用 result
    println(result)
}

fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}
// 缩写
fun arrayOfMinusOnes2(size: Int): IntArray = IntArray(size).apply { fill(-1) }

class Turtle {
    fun penDown() { println("Turtle penDown") }
    fun penUp() { println("Turtle penUp") }
    fun turn(degrees: Double) { println("Turtle degrees = $degrees") }
    fun forward(pixels: Double) { println("Turtle pixels = $pixels") }
}

fun withUsage() {
    val myTurtle = Turtle()
    with(myTurtle) {
        penDown()
        for(i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
}

fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
    return c.toInt() - '0'.toInt() // 显式转换为数字
}

fun returnUsage() {
//    listOf(1, 2, 3, 4, 5).forEach {
//        if (it == 3) return // 非局部直接返回到 foo() 的调用者
//        print(it)
//    }
//    println("this point is unreachable")

//    listOf(1, 2, 3, 4, 5).forEach lit@{
//        if (it == 3) return@lit // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
//        print(it)
//    }
//    print(" done with explicit label")

    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
        print(it)
    }
    print(" done with implicit label")
}