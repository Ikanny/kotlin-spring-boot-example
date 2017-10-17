package com.realtonerlab.example.interfaces.controller

import org.joda.time.DateTime
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author ryuikhan
 * @since 2017. 10. 17.
 */
data class CurrentTimeDto(val currentTime: Long)

@RestController
@RequestMapping("/api")
class TestController {

    @GetMapping("/current-time")
    fun getCurrentTime() = CurrentTimeDto(System.currentTimeMillis())
}