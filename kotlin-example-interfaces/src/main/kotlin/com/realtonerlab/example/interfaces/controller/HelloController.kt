package com.realtonerlab.example.interfaces.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello() = "hello"
}