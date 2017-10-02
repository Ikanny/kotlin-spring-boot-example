package com.realtonerlab.example.interfaces.controller

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import org.assertj.core.api.Assertions.assertThat

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */

@RunWith(JUnit4::class)
class HelloControllerTest {

    private val helloController = HelloController()

    @Test
    fun `test hello endpoint`() {
        val result = helloController.hello()

        assertThat(result).isEqualToIgnoringCase("hello")
    }
}