package com.realtonerlab.example.domain.persistence.jooq.converter

import org.joda.time.DateTime
import org.jooq.Converter
import java.sql.Timestamp

/**
 * @author ryuikhan
 * @since 2017. 10. 24.
 */
class JodaTimeConverter : Converter<Timestamp, DateTime> {
    override fun from(timestamp: Timestamp?): DateTime = timestamp?.let {
        DateTime(timestamp)
    } ?: throw IllegalArgumentException("")

    override fun fromType(): Class<Timestamp> = Timestamp::class.java

    override fun to(dateTime: DateTime?): Timestamp = dateTime?.let {
        Timestamp(dateTime.millis)
    } ?: throw IllegalArgumentException("")

    override fun toType(): Class<DateTime> = DateTime::class.java
}