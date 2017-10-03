package com.realtonerlab.example.domain.model.myfirstrecord

import com.realtonerlab.example.domain.model.KotlinExampleModel
import org.joda.time.DateTime
import java.util.*

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
data class MyFirstRecord(val id: Long?,
                         val name: String,
                         val createdAt: DateTime = DateTime.now(),
                         val modifiedAt: DateTime = DateTime.now()) : KotlinExampleModel()

data class MyFirstRecordWithDetails(val id: Long?,
                                    val name: String,
                                    val createdAt: DateTime = DateTime.now(),
                                    val modifiedAt: DateTime = DateTime.now(),
                                    val details: List<MyFirstRecordDetail> = emptyList()) : KotlinExampleModel()