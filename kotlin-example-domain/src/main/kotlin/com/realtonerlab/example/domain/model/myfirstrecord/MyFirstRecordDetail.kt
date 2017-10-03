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
                          val description: String,
                          val createdAt: DateTime = DateTime.now(),
                          val modifiedAt: DateTime = DateTime.now()) : KotlinExampleModel() {

    override fun hashCode(): Int = Objects.hash(id, recordId, description)

    override fun equals(other: Any?): Boolean = other?.let {
        if (it !is MyFirstRecordDetail) {
            return false
        }

        return this.id == it.id && this.recordId == it.recordId && this.description == it.description
    } ?: false
}