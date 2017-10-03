package com.realtonerlab.example.interfaces.controller

import com.realtonerlab.example.domain.dto.MyFirstRecordDto
import com.realtonerlab.example.domain.dto.MyFirstRecordWithDetailsDto
import com.realtonerlab.example.domain.service.MyFirstRecordService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@RestController
class MyFirstRecordController(private val myFirstRecordService: MyFirstRecordService) {
    companion object {
        private val log = LoggerFactory.getLogger(MyFirstRecordController::class.java)
    }


    @GetMapping("/record/{id}")
    fun getById(@PathVariable("id") id: Long): ResponseEntity<MyFirstRecordDto> {
        if (id < 1) {
            return ResponseEntity.badRequest().build()
        }

        return myFirstRecordService.findById(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.badRequest().build()
    }

    @GetMapping("/record/{id}/details")
    fun getByIdWithDetails(@PathVariable("id") id: Long): ResponseEntity<MyFirstRecordWithDetailsDto> {
        if (id < 1) {
            return ResponseEntity.badRequest().build()
        }

        return myFirstRecordService.findByIdWithDetails(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.badRequest().build()
    }
}