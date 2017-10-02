package com.realtonerlab.example.interfaces.controller

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import org.assertj.core.api.Assertions.assertThat

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */

class TestClass(private var name: String) {
    val good: Boolean get() = this.name.length == 1

    fun change() {
        this.name = name + "good"
    }
}

@RunWith(JUnit4::class)
class HelloControllerTest {

    private val helloController = HelloController()

    @Test
    fun `test hello endpoint`() {
        val result = helloController.hello()

        assertThat(result).isEqualToIgnoringCase("hello")
    }

    @Test
    fun `test for test`() {

    }
}