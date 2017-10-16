package com.realtonerlab.example.interfaces

import com.realtonerlab.example.domain.KotlinExampleDomainConfiguration
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.Import

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = arrayOf(DataSourceAutoConfiguration::class))
@Import(KotlinExampleDomainConfiguration::class)
class ExampleApplication : CommandLineRunner {

    override fun run(vararg args: String?) {

    }
}

fun main(args: Array<String>) {
    SpringApplication.run(ExampleApplication::class.java, *args)
}