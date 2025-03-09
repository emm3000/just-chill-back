package com.emm.justchill.playground

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import kotlin.test.assertTrue

@SpringBootTest
class AuthConfigTest {

    @Test
    fun `Test something users`() {
        val build = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build()

        println(build.password)
    }

    @Test
    fun `playing with Bcrypt`() {
        val encoder = BCryptPasswordEncoder(16)
        val result = encoder.encode("secret")
        assertTrue(encoder.matches("secret", result))
    }
}