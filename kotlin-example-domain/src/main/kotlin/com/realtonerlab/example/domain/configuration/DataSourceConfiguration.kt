package com.realtonerlab.example.domain.configuration

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

/**
 * @author ryuikhan
 * @since 2017. 10. 4.
 */
@Configuration
class DataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties
    fun dataSourceProperties(): DataSourceProperties = DataSourceProperties()

    @Value("\${spring.datasource.hikari.connection-timeout}")
    private var connectionTimeout: Long = 0

    @Value("\${spring.datasource.hikari.maximum-pool-size}")
    private var maximumPoolSize: Int = 0

    @Bean
    @Primary
    fun dataSource(): DataSource {
        val dataSourceProperties = dataSourceProperties()
        val dataSource = DataSourceBuilder
                .create(dataSourceProperties.classLoader)
                .driverClassName(dataSourceProperties.driverClassName)
                .url(dataSourceProperties.url)
                .username(dataSourceProperties.username)
                .password(dataSourceProperties.password)
                .type(HikariDataSource::class.java)
                .build() as HikariDataSource

        dataSource.connectionTimeout = connectionTimeout
        dataSource.maximumPoolSize = maximumPoolSize

        return dataSource
    }
}