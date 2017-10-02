package com.realtonerlab.example.domain.dto

import org.joda.time.DateTime

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
data class MyFirstRecordDto(val id: Long,
                            val name: String,
                            val createdAt: DateTime,
                            val modifiedAt: DateTime)