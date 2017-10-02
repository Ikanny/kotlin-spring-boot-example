package com.realtonerlab.example.domain.service

import com.realtonerlab.example.domain.dto.MyFirstRecordDto
import com.realtonerlab.example.domain.model.my_first_record.MyFirstRecordRepository
import org.springframework.stereotype.Service

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@Service
class MyFirstRecordService(private val myFirstRecordRepository: MyFirstRecordRepository) {

    fun findById(id: Long): MyFirstRecordDto? =
            myFirstRecordRepository.findById(id)?.let {
                MyFirstRecordDto(
                        it.id ?: throw RuntimeException(""),
                        it.name,
                        it.createdAt,
                        it.modifiedAt
                )
            }
}