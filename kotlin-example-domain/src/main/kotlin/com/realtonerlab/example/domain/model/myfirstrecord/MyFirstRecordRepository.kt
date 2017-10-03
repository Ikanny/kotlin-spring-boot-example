package com.realtonerlab.example.domain.model.myfirstrecord

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
interface MyFirstRecordRepository {

    fun findById(id: Long): MyFirstRecord?
    fun findByIdWithDetails(id: Long): MyFirstRecordWithDetails?
}