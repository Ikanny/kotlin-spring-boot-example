package com.realtonerlab.example.domain.model.myfirstrecord

import com.realtonerlab.example.domain.generated.tables.MyFirstRecordDetails.MY_FIRST_RECORD_DETAILS
import com.realtonerlab.example.domain.generated.tables.MyFirstRecords.MY_FIRST_RECORDS
import com.realtonerlab.example.domain.model.KotlinExampleModelException
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@Repository
class JooqMyFirstRecordRepository(private val dslContext: DSLContext) : MyFirstRecordRepository {

    override fun create(myFirstRecord: MyFirstRecord): MyFirstRecord? =
            dslContext.insertInto(MY_FIRST_RECORDS)
                    .set(MY_FIRST_RECORDS.NAME, myFirstRecord.name)
                    .set(MY_FIRST_RECORDS.CREATEDAT, myFirstRecord.createdAt)
                    .set(MY_FIRST_RECORDS.MODIFIEDAT, myFirstRecord.modifiedAt)
                    .returning()
                    .fetchOne()
                    ?.into(MyFirstRecord::class.java)

    override fun findAll(): List<MyFirstRecord> =
            dslContext.selectFrom(MY_FIRST_RECORDS)
                    .fetch()
                    ?.into(MyFirstRecord::class.java)
                    ?: emptyList()

    override fun findById(id: Long): MyFirstRecord? =
            dslContext
                    .selectFrom(MY_FIRST_RECORDS)
                    .where(MY_FIRST_RECORDS.ID.eq(id))
                    .fetchOne()
                    ?.into(MyFirstRecord::class.java)

    override fun findByIdWithDetails(id: Long): MyFirstRecordWithDetails? {
        val resultList = dslContext
                .selectFrom(MY_FIRST_RECORDS.leftJoin(MY_FIRST_RECORD_DETAILS)
                        .on(MY_FIRST_RECORDS.ID.eq(MY_FIRST_RECORD_DETAILS.RECORDID)))
                .where(MY_FIRST_RECORDS.ID.eq(id))
                .fetchGroups(MY_FIRST_RECORDS)
                .map { (myFirstRecord, myFirstRecordDetails) ->
                    MyFirstRecordWithDetails(myFirstRecord.into(MyFirstRecord::class.java), myFirstRecordDetails.map {
                        it.into(MY_FIRST_RECORD_DETAILS).into(MyFirstRecordDetail::class.java)
                    })
                }

        return when {
            resultList.size == 1 -> resultList.first()
            resultList.isEmpty() -> null
            else -> throw KotlinExampleModelException("Illegal state duplicate primary key. $id")
        }
    }
}