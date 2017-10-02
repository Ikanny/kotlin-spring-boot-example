package com.realtonerlab.example.domain.model.my_first_record

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
interface MyFirstRecordRepository {

    fun findById(id: Long): MyFirstRecord?
}