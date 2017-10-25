package com.realtonerlab.example.domain.model

import org.joda.time.DateTime
import java.io.Serializable
import javax.persistence.Column

/**
 * @author ryuikhan
 * @since 2017. 10. 3.
 */
abstract class KotlinExampleModel : Serializable

interface Creatable {
    val createdAt: DateTime
}

interface Modifiable {
    val modifiedAt: DateTime
}

abstract class DefaultKotlinExampleModel(@Column(name = "createdAt") override val createdAt: DateTime,
                                         @Column(name = "modifiedAt") override val modifiedAt: DateTime)
    : KotlinExampleModel(), Creatable, Modifiable