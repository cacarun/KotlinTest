package com.test.me.test

import android.content.Context
import android.util.AttributeSet
import android.view.View


class Person1(val firstName: String, val lastName: String, var age: Int) { /*……*/ }

class Person2(val name: String) {
    init {
        println("Init block")
    }

    var children: MutableList<Person2> = mutableListOf()

    constructor(name: String, parent: Person2) : this(name) {
        println("Init constructor")
        parent.children.add(this)
    }
}


class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class Person3(val name: String = "")


//--------------------------------------------


open class Father(p: Int)
class Son1(p: Int) : Father(p)
class Son2 : Father {
    constructor(p: Int) : super(p)
}

class MyView : View {
    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
}


open class Shape {
    open val vertexCount: Int = 0

    open fun draw() { /*……*/ }
    fun fill() { /*……*/ }
}
class Circle() : Shape() {
    override val vertexCount: Int = 4

    override fun draw() { /*……*/ }
}


interface Shape2 {
    val vertexCount: Int
}
class Rectangle2(override val vertexCount: Int = 4) : Shape2 // 总是有 4 个顶点
class Polygon2 : Shape2 {
    override var vertexCount: Int = 0  // 以后可以设置为任何数
}


//--------------------------------------------


open class Base(val name: String) {

    init { println("Initializing Base") }

    open val size: Int =
        name.length.also { println("Initializing size in Base: $it") }
}
class Derived(
    name: String,
    val lastName: String
) : Base(name.capitalize().also { println("Argument for Base: $it") }) {

    init { println("Initializing Derived") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}


open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}
class FilledRectangle : Rectangle() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}


open class Rectangle3 {
    open fun draw() { println("Drawing a rectangle") }
    open val borderColor: String get() = "black"
}
class FilledRectangle2: Rectangle3() {
    override fun draw() { println("FilledRectangle2 draw") }
    override val borderColor: String get() = "white"

    inner class Filler {
        fun fill() { println("fill") }
        fun drawAndFill() {
            super@FilledRectangle2.draw() // 调用 Rectangle 的 draw() 实现
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle2.borderColor}") // 使用 Rectangle 所实现的 borderColor 的 get()
        }
    }
}


open class Rectangle4 {
    open fun draw() { /* …… */ }
}
interface Polygon {
    fun draw() { /* …… */ } // 接口成员默认就是“open”的
}
class Square() : Rectangle4(), Polygon {
    // 编译器要求覆盖 draw()：
    override fun draw() {
        super<Rectangle4>.draw() // 调用 Rectangle.draw()
        super<Polygon>.draw() // 调用 Polygon.draw()
    }
}


open class Polygon3 {
    open fun draw() {}
}
abstract class Rectangle5 : Polygon3() {
    abstract override fun draw()
}


const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

class Test001 {

    private val size = 4

    lateinit var subject: String

    var stringRepresentation: String
        get() = this.toString()
        set(value) {
        }
    val isEmpty: Boolean
        get() = this.size == 0

    var counter = 0 // 注意：这个初始器直接为幕后字段赋值
//        set(value) {
//            if (value >= 0) field = value
//        }
}


//--------------------------------------------


interface MyInterface {
    val prop: Int // 抽象的

    val propertyWithImplementation: String
        get() = "foo"

    fun bar()
    fun foo() {
        // 可选的方法体
        print(prop)
    }
}
class MyChild : MyInterface {
    override val prop: Int = 29
    override fun bar() {
        //
    }
}

interface Named01 {
    val name: String
}
interface Person01 : Named01 {
    val firstName: String
    val lastName: String

    override val name: String get() = "$firstName $lastName"
}
data class Employee(
    // 不必实现“name”
    override val firstName: String,
    override val lastName: String,
    val position: Int
) : Person01


//--------------------------------------------


internal fun Int.asIdToString():String {
    return "ccc $this"
}


private fun foo() { /**/ }
public var bar: Int = 5 // 该属性随处可见
    private set         // setter 只在 example.kt 内可见
internal val baz = 6    // 相同模块内可见





fun main() {

//    val orderDemo = InitOrderDemo("order demo")

//    Person2("ccc", Person2("jjj"))

//    Person3()

//    Derived("hello", "world")

//    FilledRectangle2().Filler().drawAndFill()

//    Test001().stringRepresentation = "2"

//    Employee("jar", "cc", 123)





}

