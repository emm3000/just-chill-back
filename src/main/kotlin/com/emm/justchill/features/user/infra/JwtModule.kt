package com.emm.justchill.features.user.infra

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JwtModule {

    @Value("\${JWT_SECRET}")
    lateinit var secret: String

    @Bean
    fun provideJwtUtils(): JwtUtils = JwtUtils(secret)
}