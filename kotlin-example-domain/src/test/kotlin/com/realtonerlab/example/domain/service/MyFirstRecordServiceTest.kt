package com.realtonerlab.example.domain.service

import com.realtonerlab.example.domain.dto.fromMyFirstRecord
import com.realtonerlab.example.domain.model.myfirstrecord.MyFirstRecord
import com.realtonerlab.example.domain.model.myfirstrecord.MyFirstRecordRepository
import com.realtonerlab.example.domain.service.MyFirstRecordService
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.joda.time.DateTime
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@RunWith(JUnit4::class)
class MyFirstRecordServiceTest {

    @Mock lateinit var mockMyFirstRecordRepository: MyFirstRecordRepository
    lateinit var myFirstRecordService: MyFirstRecordService

    @Before
    fun beforeEach() {
        MockitoAnnotations.initMocks(this)
        myFirstRecordService = MyFirstRecordService(mockMyFirstRecordRepository)
    }

    @Test
    fun `test findById successful case`() {
        val testId = 1L
        val testName = "testName"
        val testCreatedAt = DateTime.now()
        val testModifiedAt = DateTime.now()

        val expectedModel = MyFirstRecord(testId, testName, testCreatedAt, testModifiedAt)
        val expected = fromMyFirstRecord(expectedModel)

        `when`(mockMyFirstRecordRepository.findById(1)).thenReturn(expectedModel)

        val result = myFirstRecordService.findById(testId)

        assertThat(result).isEqualTo(expected)
        verify(mockMyFirstRecordRepository, times(1)).findById(testId)
    }

    @Test
    fun `test findById when invalid id is given`() {
        val testId = -1L
        assertThatThrownBy { myFirstRecordService.findById(testId) }
    }
}