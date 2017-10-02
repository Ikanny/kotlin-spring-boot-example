package com.realtonerlab.example.domain

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
class KotlinExampleDomainException(msg: String = "", exception: Exception? = null) :
        RuntimeException(msg, exception)