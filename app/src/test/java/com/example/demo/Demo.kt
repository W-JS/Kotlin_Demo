package com.example.demo

/**
 * 参考：【Java里的static在Kotlin里如何实现】https://blog.csdn.net/p1830095583/article/details/115494826
 */
fun main(args: Array<String>) {
    println("Hello World")

    val wjs = Example()
    wjs.testFun()

    // 1、java的静态变量和方法，在kotlin中使用伴生对象替代
    // 2、java的静态初始化，在kotlin中使用伴生对象的init替代
    // 3、java的静态内部类，在kotlin中使用嵌套类来替代
    println(Example.STATIC_VAR)
    Example.staticMethod("类似于 Java 中的 静态方法")

    val innerClass = wjs.InnerClass()
    innerClass.innerClassMethod()

    val staticInnerClass = Example.StaticInnerClass()
    staticInnerClass.staticInnerClassMethod()
}

class Example {
    private var name: String = "wanjinsheng"
    fun testFun() {
        println(name)
    }

    companion object {
        // 类似于 Java 中的 静态变量
        var STATIC_VAR: String = "Hello World"

        // 类似于 Java 中的 静态方法
        fun staticMethod(str: String?) {
            println(str)
        }

        // 类似于 Java 中的 静态块初始化
        init {
            STATIC_VAR = "类似于 Java 中的 静态变量"
            println("in companion object init，类似于 Java 中的 静态块初始化")
        }
    }

    // 类似于 Java 中的 普通内部类
    inner class InnerClass {
        fun innerClassMethod() {
            name = "内部类 类似于 Java 中的 普通内部类"
            println(name)
        }
    }

    // 类似于 Java 中的 静态内部类
    class StaticInnerClass {
        fun staticInnerClassMethod() {
            val name = "嵌套类 类似于 Java 中的 静态内部类"
            println(name)
        }
    }
}