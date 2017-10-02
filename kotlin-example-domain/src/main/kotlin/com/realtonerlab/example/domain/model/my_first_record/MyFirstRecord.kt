package com.realtonerlab.example.domain.model.my_first_record

import org.joda.time.DateTime

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
data class MyFirstRecord(val id: Long?,
                         val name: String,
                         val createdAt: DateTime = DateTime.now(),
                         val modifiedAt: DateTime = DateTime.now())