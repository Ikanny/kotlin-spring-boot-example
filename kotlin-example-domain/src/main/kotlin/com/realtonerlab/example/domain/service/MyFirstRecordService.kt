package com.realtonerlab.example.domain.service

import com.google.common.base.Preconditions
import com.realtonerlab.example.domain.dto.MyFirstRecordDto
import com.realtonerlab.example.domain.model.myfirstrecord.MyFirstRecordRepository
import org.springframework.stereotype.Service

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@Service
class MyFirstRecordService(private val myFirstRecordRepository: MyFirstRecordRepository) {

    fun findById(id: Long): MyFirstRecordDto? {
        Preconditions.checkArgument(id > 0)

        return myFirstRecordRepository.findById(id)?.let {
            MyFirstRecordDto(
                    it.id ?: throw RuntimeException("id of MyFirstRecordDto cannot be null."),
                    it.name,
                    it.createdAt,
                    it.modifiedAt
            )
        }
    }
}