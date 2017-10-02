package com.realtonerlab.example.domain.model.my_first_record

import net.realtonerlab.example.domain.generated.tables.MyFirstRecords.MY_FIRST_RECORDS
import org.joda.time.DateTime
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@Repository
class JooqMyFirstRecordRepository(private val dslContext: DSLContext) : MyFirstRecordRepository {

    override fun findById(id: Long): MyFirstRecord? {
        return dslContext.selectFrom(MY_FIRST_RECORDS).fetchOne()?.let {
            MyFirstRecord(
                    it.id,
                    it.name,
                    DateTime(it.createdat),
                    DateTime(it.modifiedat))
        }
    }

}