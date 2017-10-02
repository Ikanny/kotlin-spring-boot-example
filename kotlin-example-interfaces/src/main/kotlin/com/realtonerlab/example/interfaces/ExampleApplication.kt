package com.realtonerlab.example.interfaces

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
class ExampleApplication

data class TestObject(val name: String?)

fun main(args: Array<String>) {

    val a = TestObject(null)
    val b = a.name ?: "fuck" .let { it.length }

    println(b)
}