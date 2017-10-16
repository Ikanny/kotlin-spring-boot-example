package com.realtonerlab.example.domain.service

import com.realtonerlab.example.domain.KotlinExampleDomainIntegrationTest
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author ryuikhan
 * @since 2017. 10. 4.
 */
class MyFirstRecordServiceIntegrationTest : KotlinExampleDomainIntegrationTest() {

    @Autowired
    private lateinit var myFirstRecordService: MyFirstRecordService

    @Test
    fun `test_test`() {

    }
}