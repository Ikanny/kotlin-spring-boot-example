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

    override fun hashCode(): Int = Objects.hash(name)

    override fun equals(other: Any?): Boolean {
        if (other !is MyFirstRecord) {
            return false
        }

        if (this.id != null && other.id != null && this.id == other.id) {
            return true
        }

        return this.name == other.name
    }
}

class MyFirstRecordWithDetails(id: Long?,
                               name: String,
                               createdAt: DateTime = DateTime.now(),
                               modifiedAt: DateTime = DateTime.now(),
                               val details: List<MyFirstRecordDetail> = emptyList()) : MyFirstRecord(id, name, createdAt, modifiedAt) {

    constructor(myFirstRecord: MyFirstRecord, details: List<MyFirstRecordDetail>) :
            this(myFirstRecord.id, myFirstRecord.name, myFirstRecord.createdAt, myFirstRecord.modifiedAt, details)

    override fun hashCode(): Int = Objects.hash(name, details)

    override fun equals(other: Any?): Boolean {
        if (other !is MyFirstRecordWithDetails) {
            return false
        }

        return super.equals(other)
    }
}