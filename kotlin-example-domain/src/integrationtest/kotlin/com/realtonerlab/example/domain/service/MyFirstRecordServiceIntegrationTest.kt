package com.realtonerlab.example.domain.service

import com.github.springtestdbunit.annotation.DatabaseSetup
import com.github.springtestdbunit.annotation.ExpectedDatabase
import com.github.springtestdbunit.assertion.DatabaseAssertionMode
import com.realtonerlab.example.domain.KotlinExampleDomainIntegrationTest
import org.assertj.core.api.Assertions.assertThat
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
    fun `create and retrieve test`() {
        val firstOne = myFirstRecordService.createMyFirstRecord("firstOne")
        val secondOne = myFirstRecordService.createMyFirstRecord("secondOne")

        val list = myFirstRecordService.findAll()

        assertThat(list).containsExactly(firstOne, secondOne)
    }

    @Test
    @DatabaseSetup("classpath:data/service/myfirstrecord/testRetrievingWithDbUnit.xml")
    fun `test retrieving with db unit`() {
        val list = myFirstRecordService.findAll()

        assertThat(list.map { it.id to it.name}).containsExactlyInAnyOrder(1L to "firstOne", 2L to "secondOne")
    }

    @Test
    @DatabaseSetup("classpath:data/service/myfirstrecord/testInsertingWithDbUnit/before.xml")
    @ExpectedDatabase(value = "classpath:data/service/myfirstrecord/testInsertingWithDbUnit/after.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    fun `test inserting with db unit`() {
        myFirstRecordService.createMyFirstRecord("thirdOne")
    }
}