package com.emm.justchill.features.user.infra

import com.emm.justchill.features.user.aplication.UserCreator
import com.emm.justchill.features.user.aplication.UserFinder
import com.emm.justchill.features.user.domain.TokenProvider
import com.emm.justchill.features.user.domain.Transformable
import com.emm.justchill.features.user.domain.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class UserModule {

    @Bean
    fun userRepository(crudRepository: CrudUserRepository): UserRepository {
        return DefaultUserRepository(crudRepository)
    }

    @Bean
    fun provideUserCreator(
        repository: UserRepository,
        transformable: Transformable,
        tokenProvider: TokenProvider,
    ): UserCreator = UserCreator(repository, transformable, tokenProvider)

    @Bean
    fun provideUserFinder(
        repository: UserRepository,
        tokenProvider: TokenProvider,
    ): UserFinder = UserFinder(repository, tokenProvider)

    @Bean
    fun providePasswordEncoder(passwordEncoder: PasswordEncoder): Transformable {
        return Transformable(passwordEncoder::encode)
    }

    @Bean
    fun provideTokenProvider(jwtUtils: JwtUtils): TokenProvider {
        return TokenProvider(jwtUtils::createToken)
    }
}