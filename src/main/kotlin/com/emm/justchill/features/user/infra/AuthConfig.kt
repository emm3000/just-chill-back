package com.emm.justchill.features.user.infra

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.config.web.server.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class AuthConfig {

    @Bean
    fun configHttp(
        httpSecurity: HttpSecurity,
        jwtFilter: JwtFilter,
        authenticationProvider: AuthenticationProvider,
    ): SecurityFilterChain {
        httpSecurity
            .csrf(CsrfConfigurer<HttpSecurity>::disable)
            .formLogin(FormLoginConfigurer<HttpSecurity>::disable)
            .httpBasic(HttpBasicConfigurer<HttpSecurity>::disable)
            .authorizeHttpRequests {
                it.requestMatchers("/auth/**").permitAll()
                it.anyRequest().authenticated()
            }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
        return httpSecurity.build()
    }

    @Bean
    fun provideAuthenticationProvider(
        crudUserRepository: CrudUserRepository,
        passwordEncoder: PasswordEncoder,
    ): AuthenticationProvider {
        val provider = DaoAuthenticationProvider()
        provider.setUserDetailsService(crudUserRepository::findByEmail)
        provider.setPasswordEncoder(passwordEncoder)
        return provider
    }

    @Bean
    fun providerPasswordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun provideAuthenticationManager(
        config: AuthenticationConfiguration,
    ): AuthenticationManager = config.authenticationManager
}