package com.realtonerlab.example.interfaces.controller

import com.realtonerlab.example.domain.dto.MyFirstRecordDto
import com.realtonerlab.example.domain.service.MyFirstRecordService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.assertj.core.api.Assertions.assertThat
import org.joda.time.DateTime
import org.mockito.Mockito.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@RunWith(JUnit4::class)
class MyFirstRecordControllerTest {

    @Mock lateinit var mockMyFirstRecordService: MyFirstRecordService
    lateinit var myFirstRecordController: MyFirstRecordController

    @Before
    fun beforeEach() {
        MockitoAnnotations.initMocks(this)
        myFirstRecordController = MyFirstRecordController(mockMyFirstRecordService)
    }

    @Test
    fun `test getById api when valid id given`() {
        val testId = 1L
        val testName = "testName"
        val returnedDto = MyFirstRecordDto(testId, testName, DateTime.now(), DateTime.now())

        `when`(mockMyFirstRecordService.findById(testId)).thenReturn(returnedDto)

        val result = myFirstRecordController.getById(testId)

        assertThat(result).isEqualTo(ResponseEntity.ok(returnedDto))
        verify(mockMyFirstRecordService, times(1)).findById(testId)
    }

    @Test
    fun `test getById when invalid id given`() {
        val testId = -1L

        val result = myFirstRecordController.getById(testId)

        assertThat(result!!.statusCode).isEqualTo(HttpStatus.BAD_REQUEST)
    }
}