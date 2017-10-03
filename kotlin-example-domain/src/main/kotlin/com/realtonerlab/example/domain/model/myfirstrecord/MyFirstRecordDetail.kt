package com.realtonerlab.example.domain.model.myfirstrecord

import com.realtonerlab.example.domain.model.KotlinExampleModel
import org.joda.time.DateTime
import java.util.*

/**
 * @author ryuikhan
 * @since 2017. 10. 3.
 */
class MyFirstRecordDetail(val id: Long?,
                          val recordId: Long,
                          val createdAt: DateTime = DateTime.now(),
                          val modifiedAt: DateTime = DateTime.now()) : KotlinExampleModel() {

    override fun hashCode(): Int = Objects.hash(id, recordId, createdAt, modifiedAt)

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}