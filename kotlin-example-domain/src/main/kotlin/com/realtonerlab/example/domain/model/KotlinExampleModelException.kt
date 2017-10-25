package com.realtonerlab.example.domain.model

import com.realtonerlab.example.domain.KotlinExampleDomainException

/**
 * @author ryuikhan
 * @since 2017. 10. 25.
 */
class KotlinExampleModelException(msg: String = "", exception: Exception? = null) : KotlinExampleDomainException(msg, exception)