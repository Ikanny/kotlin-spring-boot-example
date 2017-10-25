package com.realtonerlab.example.domain.model.myfirstrecord

import com.realtonerlab.example.domain.model.DefaultKotlinExampleModel
import org.joda.time.DateTime
import java.util.*
import javax.persistence.Column

/**
 * @author ryuikhan
 * @since 2017. 10. 3.
 */
class MyFirstRecordDetail(@Column(name = "id") val id: Long?,
                          @Column(name = "recordId") val recordId: Long,
                          @Column(name = "description") val description: String,
                          createdAt: DateTime = DateTime.now(),
                          modifiedAt: DateTime = DateTime.now()) : DefaultKotlinExampleModel(createdAt, modifiedAt) {

    override fun hashCode(): Int = Objects.hash(id, recordId, description)

    override fun equals(other: Any?): Boolean = other?.let {
        if (it !is MyFirstRecordDetail) {
            return false
        }

        return this.id == it.id && this.recordId == it.recordId && this.description == it.description
    } ?: false
}