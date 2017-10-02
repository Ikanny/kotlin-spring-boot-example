package com.realtonerlab.example.domain.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.joda.JodaModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@Configuration
class ObjectMapperConfiguration {

    @Bean
    fun objectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.registerModule(JodaModule())
        return objectMapper
    }
}