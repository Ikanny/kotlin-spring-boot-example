package com.realtonerlab.example.domain

import com.github.springtestdbunit.DbUnitTestExecutionListener
import com.realtonerlab.example.domain.configuration.DataSourceConfiguration
import org.flywaydb.core.Flyway
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import javax.annotation.PostConstruct
import javax.sql.DataSource

/**
 * @author ryuikhan
 * @since 2017. 10. 4.
 */
@RunWith(SpringRunner::class)
@TestExecutionListeners(listeners = arrayOf(DependencyInjectionTestExecutionListener::class, DbUnitTestExecutionListener::class))
@SpringBootTest(classes = arrayOf(KotlinExampleDomainIntegrationTest.KotlinExampleDomainIntegrationTestConfiguration::class))
abstract class KotlinExampleDomainIntegrationTest {

    @Autowired
    private lateinit var flyway: Flyway

    @PostConstruct
    fun postConstruct() {
        flyway.clean()
        flyway.migrate()
    }

    @Configuration
    @Import(DataSourceConfiguration::class)
    @EnableAutoConfiguration(exclude = arrayOf(DataSourceAutoConfiguration::class))
    @SpringBootApplication
    class KotlinExampleDomainIntegrationTestConfiguration {
        companion object {
            fun main(args: Array<String>) = SpringApplication.run(KotlinExampleDomainIntegrationTestConfiguration::class.java, *args)
        }

        @Autowired
        private lateinit var dataSource: DataSource

        @Bean
        fun flyway(): Flyway {
            val flyway = Flyway()
            flyway.dataSource = dataSource
            return flyway
        }
    }
}