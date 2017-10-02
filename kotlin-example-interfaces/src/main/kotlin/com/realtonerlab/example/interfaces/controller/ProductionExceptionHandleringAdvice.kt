package com.realtonerlab.example.interfaces.controller

import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.ControllerAdvice

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@ControllerAdvice
@Profile("production")
class ProductionExceptionHandleringAdvice {

}