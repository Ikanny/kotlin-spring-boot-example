package com.realtonerlab.example.domain.model.myfirstrecord

import com.realtonerlab.example.domain.generated.tables.MyFirstRecordDetails.MY_FIRST_RECORD_DETAILS
import com.realtonerlab.example.domain.generated.tables.MyFirstRecords.MY_FIRST_RECORDS
import org.joda.time.DateTime
import org.jooq.DSLContext
import org.jooq.Record
import org.springframework.stereotype.Repository

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@Repository
class JooqMyFirstRecordRepository(private val dslContext: DSLContext) : MyFirstRecordRepository {

    override fun findById(id: Long): MyFirstRecord? =
            dslContext
                    .selectFrom(MY_FIRST_RECORDS)
                    .where(MY_FIRST_RECORDS.ID.eq(id))
                    .fetchOne()?.let {
                MyFirstRecord(it.id, it.name, it.createdat, it.modifiedat)
            }

    override fun findByIdWithDetails(id: Long): MyFirstRecordWithDetails? =
            dslContext
                    .selectFrom(MY_FIRST_RECORDS.leftJoin(MY_FIRST_RECORD_DETAILS)
                            .on(MY_FIRST_RECORDS.ID.eq(MY_FIRST_RECORD_DETAILS.RECORDID)))
                    .where(MY_FIRST_RECORDS.ID.eq(id))
                    .fetch()
                    ?.let {
                        if (it.size != 1) {
                            return null
                        }

                        val entry = it.groupBy { toMyFirstRecord(it) }.entries.first()
                        val myFirstRecord = entry.key
                        val rows = entry.value
                        val details = rows
                                .filter { it.getValue(MY_FIRST_RECORD_DETAILS.ID) != null }
                                .map { toMyFirstRecordDetail(it) }

                        MyFirstRecordWithDetails(myFirstRecord, details)
                    }

    private fun toMyFirstRecord(record: Record): MyFirstRecord =
            MyFirstRecord(record.getValue(MY_FIRST_RECORDS.ID),
                    record.getValue(MY_FIRST_RECORDS.NAME),
                    DateTime(record.getValue(MY_FIRST_RECORDS.CREATEDAT)),
                    DateTime(record.getValue(MY_FIRST_RECORDS.MODIFIEDAT)))

    private fun toMyFirstRecordDetail(record: Record): MyFirstRecordDetail =
            MyFirstRecordDetail(record.getValue(MY_FIRST_RECORD_DETAILS.ID),
                    record.getValue(MY_FIRST_RECORD_DETAILS.RECORDID),
                    record.getValue(MY_FIRST_RECORD_DETAILS.DESCRIPTION),
                    record.getValue(MY_FIRST_RECORD_DETAILS.CREATEDAT),
                    record.getValue(MY_FIRST_RECORD_DETAILS.MODIFIEDAT))
}