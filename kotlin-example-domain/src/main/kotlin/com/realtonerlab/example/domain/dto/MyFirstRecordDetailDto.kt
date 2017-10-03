package com.realtonerlab.example.domain.dto

import com.realtonerlab.example.domain.KotlinExampleDomainException
import com.realtonerlab.example.domain.model.myfirstrecord.MyFirstRecordDetail
import org.joda.time.DateTime

/**
 * @author ryuikhan
 * @since 2017. 10. 3.
 */
fun fromMyFirstRecordDetail(myFirstRecordDetail: MyFirstRecordDetail) =
        MyFirstRecordDetailDto(myFirstRecordDetail.id ?: throw KotlinExampleDomainException("id cannot be null"),
                myFirstRecordDetail.recordId,
                myFirstRecordDetail.description,
                myFirstRecordDetail.createdAt,
                myFirstRecordDetail.modifiedAt)

data class MyFirstRecordDetailDto(val id: Long,
                                  val recordId: Long,
                                  val description: String,
                                  val createdAt: DateTime,
                                  val modifiedAt: DateTime)