package com.emm.justchill.playground

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import java.util.UUID

@SpringBootTest
class PlaygroundTest {

    @Autowired
    lateinit var objectTemplate: JdbcTemplate

    @Test
    fun create() {
        val sql = "INSERT INTO users (user_id, name, email, password_hash) VALUES (?, ?, ?, ?)"
        objectTemplate.update(sql, UUID.randomUUID().toString(), "John Doe", "john@example.com", "hashed_password")
    }
}