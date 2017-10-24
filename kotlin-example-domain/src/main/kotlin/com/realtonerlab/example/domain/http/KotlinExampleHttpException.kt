package com.realtonerlab.example.domain.http

import com.realtonerlab.example.domain.KotlinExampleDomainException

/**
 * @author ryuikhan
 * @since 2017. 10. 24.
 */
class KotlinExampleHttpException(msg: String = "", exception: Exception? = null) :
        KotlinExampleDomainException(msg, exception)