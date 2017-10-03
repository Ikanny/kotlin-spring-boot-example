package com.realtonerlab.example.interfaces.controller

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@ControllerAdvice
@Profile("production")
class ProductionExceptionHandlingAdvice : ResponseEntityExceptionHandler() {

    companion object {
        private val log = LoggerFactory.getLogger(ProductionExceptionHandlingAdvice::class.java)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<Exception> {
        log.error("exception occurs.", exception)
        return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
    }
}