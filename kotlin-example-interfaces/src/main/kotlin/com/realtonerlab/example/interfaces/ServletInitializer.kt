package com.realtonerlab.example.interfaces

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer

/**
 * @author ryuikhan
 * @since 2017. 10. 4.
 */
class ServletInitializer : SpringBootServletInitializer() {

    override fun configure(builder: SpringApplicationBuilder?): SpringApplicationBuilder {
        return builder!!.sources(ExampleApplication::class.java)
    }
}