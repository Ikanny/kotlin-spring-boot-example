package com.realtonerlab.example.domain

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * @author ryuikhan
 * @since 2017. 10. 2.
 */
@Configuration
@ComponentScan(basePackageClasses = arrayOf(KotlinExampleDomainConfiguration::class))
class KotlinExampleDomainConfiguration