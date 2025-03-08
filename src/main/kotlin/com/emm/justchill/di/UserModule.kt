package com.emm.justchill.di

import com.emm.justchill.features.user.aplication.UserCreator
import com.emm.justchill.features.user.domain.UserRepository
import com.emm.justchill.features.user.infra.CrudUserRepository
import com.emm.justchill.features.user.infra.DefaultUserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserModule {

    @Bean
    fun userRepository(crudRepository: CrudUserRepository): UserRepository {
        return DefaultUserRepository(crudRepository)
    }

    @Bean
    fun provideUserCreator(repository: UserRepository): UserCreator {
        return UserCreator(repository)
    }
}