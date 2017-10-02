package com.realtonerlab.example.domain.dto

import com.realtonerlab.example.domain.KotlinExampleDomainException
import com.realtonerlab.example.domain.model.my_first_record.MyFirstRecord
import org.joda.time.DateTime

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
fun fromMyFirstRecord(myFirstRecord: MyFirstRecord): MyFirstRecordDto =
        MyFirstRecordDto(myFirstRecord.id ?: throw KotlinExampleDomainException(""),
                myFirstRecord.name,
                myFirstRecord.createdAt,
                myFirstRecord.modifiedAt)

data class MyFirstRecordDto(val id: Long,
                            val name: String,
                            val createdAt: DateTime,
                            val modifiedAt: DateTime)