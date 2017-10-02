package com.realtonerlab.example.interfaces

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@EnableAutoConfiguration(exclude = arrayOf(DataSourceAutoConfiguration::class))
@SpringBootApplication
class ExampleApplication

fun main(args: Array<String>) {
    SpringApplication.run(ExampleApplication::class.java, *args)
}