package com.realtonerlab.example.domain.dto

import com.realtonerlab.example.domain.KotlinExampleDomainException
import com.realtonerlab.example.domain.model.myfirstrecord.MyFirstRecord
import com.realtonerlab.example.domain.model.myfirstrecord.MyFirstRecordWithDetails
import org.joda.time.DateTime

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
fun fromMyFirstRecord(myFirstRecord: MyFirstRecord): MyFirstRecordDto =
        MyFirstRecordDto(myFirstRecord.id ?: throw KotlinExampleDomainException("id cannot be null"),
                myFirstRecord.name,
                myFirstRecord.createdAt,
                myFirstRecord.modifiedAt)

data class MyFirstRecordDto(val id: Long,
                            val name: String,
                            val createdAt: DateTime,
                            val modifiedAt: DateTime)

fun fromMyFirstRecordWithDetails(myFirstRecordWithDetails: MyFirstRecordWithDetails): MyFirstRecordWithDetailsDto =
        MyFirstRecordWithDetailsDto(myFirstRecordWithDetails.id ?: throw KotlinExampleDomainException("id cannot be null"),
                myFirstRecordWithDetails.name,
                myFirstRecordWithDetails.details.map { fromMyFirstRecordDetail(it) },
                myFirstRecordWithDetails.createdAt,
                myFirstRecordWithDetails.modifiedAt)

data class MyFirstRecordWithDetailsDto(val id: Long,
                                       val name: String,
                                       val details: List<MyFirstRecordDetailDto>,
                                       val createdAt: DateTime,
                                       val modifiedAt: DateTime)