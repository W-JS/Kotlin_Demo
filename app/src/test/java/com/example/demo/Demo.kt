package com.example.demo

fun main(args: Array<String>) {
    println("Hello World")

    val wjs = Example()
    wjs.testFun()
}

class Example {
    private val name: String = "wanjinsheng"
    fun testFun() {
        println(name)
    }
}