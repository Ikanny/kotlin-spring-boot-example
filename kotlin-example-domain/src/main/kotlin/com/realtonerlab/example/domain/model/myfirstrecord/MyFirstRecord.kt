package com.realtonerlab.example.domain.model.myfirstrecord

import com.realtonerlab.example.domain.model.KotlinExampleModel
import org.joda.time.DateTime
import java.util.*

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
open class MyFirstRecord(val id: Long?,
                           val name: String,
                           val createdAt: DateTime = DateTime.now(),
                           val modifiedAt: DateTime = DateTime.now()) : KotlinExampleModel() {

    override fun hashCode(): Int = Objects.hash(id, name)

    override fun equals(other: Any?): Boolean = other?.let {
        if (it !is MyFirstRecord) {
            return false
        }

        return this.id == it.id && this.name == it.name
    } ?: false

}

class MyFirstRecordWithDetails(id: Long?,
                               name: String,
                               val details: List<MyFirstRecordDetail> = emptyList()) : MyFirstRecord(id, name) {

    override fun hashCode(): Int = Objects.hash(id, name, details)

    override fun equals(other: Any?): Boolean = other?.let {
        if (it !is MyFirstRecordWithDetails) {
            return false
        }

        return this.id == it.id && this.name == it.name && Objects.equals(this.details, details)
    } ?: false
}